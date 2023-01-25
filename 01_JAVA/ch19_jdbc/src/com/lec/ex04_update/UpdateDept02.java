package com.lec.ex04_update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 수정할 부서번호와 부서명, 근무지를 입력받아 update
// 존재하는 부서번호인지 확인 후 정보요청
public class UpdateDept02 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs	= null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
				System.out.print("수정을 원하는 부서 번호를 입력하세요: ");
				int deptno = sc.nextInt();
				String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = " + deptno;
				rs	 = stmt.executeQuery(selectQuery);
				rs.next();
				int cnt = rs.getInt("cnt");
				
				if (cnt == 0) {
					System.out.println("검색하신 부서는 존재하지 않습니다.");
				} else {
					System.out.print("변경할 부서명: ");
					String dname = sc.next();
					System.out.print("변경할 부서 위치: ");
					String loc = sc.next();
					String updateQuery = String.format("UPDATE DEPT SET DNAME = '%s', LOC = '%s' WHERE DEPTNO = %d", dname, loc,
							deptno);
					
					int result = stmt.executeUpdate(updateQuery); // insert, update, delete : excute
					System.out.println(result > 0 ? deptno + "번 부서 정보 수정 완료" : "검색하신 부서는 없습니다.");
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
				e.printStackTrace();
			}
		}
	}
}
