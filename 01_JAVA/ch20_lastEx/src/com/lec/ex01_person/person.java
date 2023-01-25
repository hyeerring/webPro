package com.lec.ex01_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class person {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

		Connection conn = null;
		PreparedStatement pstmt = null; // 1, 2번
		Statement stmt = null; // 3번
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String fn;

		ArrayList<String> jobs = new ArrayList<String>(); // 직업명들 저장
		// 직업명들을 jobs에 add
		try {
			String sql = "SELECT JNAME FROM JOB";
			Class.forName(driver); // (1)드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
			stmt = conn.createStatement();// (3)
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				jobs.add(rs.getString("jname"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

			}
			System.out.println(jobs); // 현재 등록된 직업 출력
			
		} // 직업명 가져오기

		do {
			System.out.print("1: 데이터 등록 | 2: 직업별 성적 조회 | 3. 전체 성적 조회 | 그외: 종료 ");
			fn = sc.next();
			switch (fn) {
			case "1":
				String insertQuery = "INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(insertQuery);
					System.out.println("등록할 사람의 정보를 입력하세요.");
					System.out.print("이름: ");
					String pname = sc.next();
					System.out.print("직업: ");
					int jNo = 0;
					switch (sc.next()) { // 직업명을 입력받아 jNo으로 insert
					case "배우":
						jNo = 10;
						break;
					case "가수":
						jNo = 20;
						break;
					case "스태프":
						jNo = 30;
						break;
					default:
						System.out.println("등록되지 않은 직업입니다. 처음으로 돌아갑니다.");
						continue;
					}
					System.out.print("국어점수: ");
					int KOR = sc.nextInt();
					System.out.print("영어점수: ");
					int ENG = sc.nextInt();
					System.out.print("수학점수: ");
					int MAT = sc.nextInt();

//					pstmt = conn.prepareStatement(insertQuery);
					pstmt.setString(1, pname);
					pstmt.setInt(2, jNo);
					pstmt.setInt(3, KOR);
					pstmt.setInt(4, ENG);
					pstmt.setInt(5, MAT);
					int result = pstmt.executeUpdate();

					System.out.println(result > 0 ? "입력되었습니다." : "입력을 실패했습니다.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} // finally
				break;

// ------------------------------------------------------------------------------------------				
			case "2":
				String selectQuery = "SELECT CONCAT(ROWNUM, '등') RN  , A.*"
						+ "    FROM (SELECT PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT TOTAL"
						+ "    FROM JOB J, PERSON P \n" + "    WHERE J.JNO = P.JNO ORDER BY TOTAL DESC) A"
						+ "    WHERE JNAME = ?";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(selectQuery);
					System.out.print("조회할 직업명을 입력하세요: ");
					String serch = sc.next();
					pstmt.setString(1, serch);
					rs = pstmt.executeQuery();

					// 해당 직업을 가진 사람 list 출력 (total순 정렬)
					if (rs.next()) {
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						do {
							String rn = rs.getString("rn");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int total = rs.getInt("total");
							System.out.printf("%s\t%s\t%s\t%d\t%d\t%d\t%d\n", rn, pname, jname, kor, eng, mat, total);
						} while (rs.next());
						System.out.println();
					} else {
						System.out.println("검색하신 직업을 가진 사람이 존재하지 않습니다.");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} // finally
				break;

// ------------------------------------------------------------------------------------------		
			case "3":
				String selectAllQuery = "SELECT CONCAT(ROWNUM, '등') RN, A.*" + 
						"    FROM (SELECT PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT TOTAL" + 
						"        FROM JOB J, PERSON P WHERE J.JNO = P.JNO ORDER BY TOTAL DESC) A";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(selectAllQuery);

					if (rs.next()) {
						System.out.println("등수\t이름\t직업\t국어\t영어\t수학\t총점");
						System.out.println("--------------------------------------------------");
						do {
							String rn = rs.getString("rn");
							String pname = rs.getString("pname");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int total = rs.getInt("total");
							System.out.printf("%s\t%s\t%s\t%d\t%d\t%d\t%d\n", rn, pname, jname, kor, eng, mat, total);
						} while (rs.next());
						System.out.println();
					} else {
						System.out.println("등록된 사람이 존재하지 않습니다.");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					try { // 7)연결해제
						if (rs != null)
							rs.close();
						if (stmt != null)
							stmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("BYE!");

	} // main

} // class
