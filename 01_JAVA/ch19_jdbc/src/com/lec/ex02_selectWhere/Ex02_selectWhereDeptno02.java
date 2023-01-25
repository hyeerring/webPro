package com.lec.ex02_selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 원하는 부서번호를 받아 부서 정보를 뿌리고 해당 부서의 사원 정보도 출력
// 1. 해당 부서번호가 없는 경우: 존재하지 않는 부서입니다.
// 2. 해당 부서번호가 있는 경우: 부서정보를 출력
// 2-1. 해당 부서에 사원이 있는 경우: 사원 정보를 출력
// 		(사번, 이름, 급여, 상사이름)
// 2-2. 해당 부서에 사원이 없는 경우: 해당 부서에 등록된 사원이 없습니다.

public class Ex02_selectWhereDeptno02 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		int deptno = sc.nextInt();

		String query1 = "SELECT * FROM DEPT WHERE DEPTNO=" + deptno;
		String query2 = "SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER" + "  FROM EMP W, EMP M"
				+ "  WHERE W.MGR=M.EMPNO AND W.DEPTNO=" + deptno;
		
		System.out.print("출력을 원하는 부서번호는 ? ");
		try {
			Class.forName(driver);// (1)
			conn = DriverManager.getConnection(url, "scott", "tiger");// (2)
			stmt = conn.createStatement(); // (3)
			rs = stmt.executeQuery(query1); // (4) + (5)
			if (rs.next()) {
				System.out.println("원하는 부서번호 : " + deptno);
				System.out.println("원하는 부서이름 : " + rs.getString("dname"));
				System.out.println("원하는 부서위치 : " + rs.getString("loc"));
				rs.close();
				rs = stmt.executeQuery(query2);
				if (rs.next()) {
					System.out.println("사번\t이름\t급여\t상사명");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						String manager = rs.getString("manager");
						System.out.println(empno + "\t" + ename + "\t" + sal + "\t" + manager);
					} while (rs.next());
				} else {
					System.out.println(deptno + "번 부서 사원은 없습니다");
				}
			} else {
				System.out.println(deptno + "는 유효한 부서번호가 아닙디다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
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
			}
		} // try-catch-finally
	}
}