package com.lec.ex06_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex01_InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		System.out.print("추가할 부서 번호를 입력하세요: ");
		int deptno = sc.nextInt();
		System.out.print("추가할 부서명을 입력하세요: ");
		String dname = sc.next();
		System.out.print("추가할 부서위치를 입력하세요: ");
		String loc = sc.next();

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql); // SQL 전송 객체

			pstmt.setInt(1, deptno); // deptno가 int라서 setInt 함수 이용
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);

			int result = pstmt.executeUpdate();
			System.out.println(result > 0 ? deptno + "번 부서 입력 완료" : "입력실패");
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
		}
	}
}
