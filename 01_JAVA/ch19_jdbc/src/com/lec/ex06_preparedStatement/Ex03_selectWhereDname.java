package com.lec.ex06_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 부서명을 받아 해상 부서 사원을 출력
// 사번, 이름, 상사이름, 급여, 급여등급
// 상사가 없는 사람은 CEO 출력
public class Ex03_selectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT W.EMPNO, W.ENAME, NVL(M.ENAME, 'CEO') MANAGER, W.SAL, GRADE"
				+ "    FROM EMP W, EMP M, DEPT D, SALGRADE" + "    WHERE W.MGR = M.EMPNO"
				+ "        AND W.DEPTNO = D.DEPTNO" + "        AND W.SAL BETWEEN LOSAL AND HISAL"
				+ "        AND DNAME = UPPER(?)";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			System.out.print("검색할 부서명을 입력하세요: ");
			pstmt.setString(1, sc.next());
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 해당 부서 사원 list 출력
				System.out.println("사번\t사원\t상사\t급여\t급여등급");
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String manager = rs.getString("manager");
					int sal = rs.getInt("sal");
					int grade = rs.getInt("grade");
					System.out.printf("%d\t%s\t%s\t%d\t%d\n", empno, ename, manager, sal, grade);
				} while (rs.next());
			} else {
				System.out.println("검색하신 부서에 사원이 없습니다.");
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
		}
	}
}
