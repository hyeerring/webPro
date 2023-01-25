package com.lec.ex02_selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// 부서 이름을 입력받아 부서 정보를 출력
public class Ex03_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		System.out.print("검색할 부서 이름을 입력하세요: ");
		String dname = sc.next();
//		String sql = "SELECT * FROM DEPT WHERE DNAME = UPPER('" + dname + "')";
		String sql = String.format("SELECT * FROM DEPT WHERE DNAME = UPPER('%s')", dname);

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // stmt.executeQuery(): select문 전송 시 사용

			if (rs.next()) {
				System.out.println("부서번호: " + rs.getInt("deptno"));
				System.out.println("부서명: " + dname);
				System.out.println("근무지: " + rs.getString("loc"));

			} else {
				System.out.println("검색하신 부서는 존재하지 않습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 7.연결해제
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
