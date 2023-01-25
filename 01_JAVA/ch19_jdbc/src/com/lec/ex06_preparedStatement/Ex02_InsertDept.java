package com.lec.ex06_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
// 입력받은 부서번호 중복 체크 후 근무지를 입력받아 insert
public class Ex02_InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = ?";
		String insertQuery = "INSERT INTO DEPT VALUES (?, ?, ?)";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectQuery);
			System.out.print("입력할 부서번호를 입력하세요: ");
			
			int deptno = sc.nextInt();
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt("cnt");
			
			if (cnt != 0) {
				System.out.println("중복된 부서 번호는 입력 불가합니다.");
			} else {
				System.out.print("입력할 부서명을 입력하세요: ");
				String dname = sc.next();
				System.out.print("입력할 부서위치를 입력하세요: ");
				String loc = sc.next();
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement(insertQuery);
				pstmt.setInt(1, deptno); // deptno가 int라서 setInt 함수 이용
				pstmt.setString(2, dname);
				pstmt.setString(3, loc);
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "입력되었습니다." : "입력을 실패했습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("중복된 부서 번호이거나 글자 수가 초과했습니다 : " + e.getMessage());
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
		}
	}
}
