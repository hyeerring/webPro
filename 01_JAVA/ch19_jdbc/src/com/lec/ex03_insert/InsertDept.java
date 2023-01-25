package com.lec.ex03_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 부서번호, 부서명, 근무지를 입력받아 insert
public class InsertDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		Statement stmt = null;

		System.out.print("입력할 부서번호를 입력하세요: ");
		int deptno = sc.nextInt();
		// 부서번호 중복체크 --> InsertDept02 class
		System.out.print("입력할 부서명을 입력하세요: ");
		String dname = sc.next();
		System.out.print("입력할 부서위치를 입력하세요: ");
		String loc = sc.next();

//		String sql = "INSERT INTO DEPT VALUES (" +deptno+ ", '" +dname+ "', '" +loc+ "')";
		String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "입력되었습니다." : "입력을 실패했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("중복된 부서 번호이거나 글자 수가 초과했습니다." + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
