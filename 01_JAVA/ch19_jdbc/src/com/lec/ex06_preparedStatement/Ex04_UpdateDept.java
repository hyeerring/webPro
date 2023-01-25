package com.lec.ex06_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 사용자에게 수정할 부서번호와 부서명, 근무지를 입력받아 update
// 존재하는 부서번호인지 확인 후 정보요청
public class Ex04_UpdateDept {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs	= null;
		String selectQuery = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = ?";
		String updateQuery = "UPDATE DEPT SET DNAME = ?, LOC = ? WHERE DEPTNO =?";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectQuery);
				System.out.print("수정을 원하는 부서 번호를 입력하세요: ");
				
				int deptno = sc.nextInt();
				pstmt.setInt(1, deptno);
				rs	 = pstmt.executeQuery();
				
				if (rs.next()) {
					System.out.print("변경할 부서명: ");
					String dname = sc.next();
					System.out.print("변경할 부서 위치: ");
					String loc = sc.next();
					
					rs.close();
					pstmt.close();
					
					pstmt = conn.prepareStatement(updateQuery);
					pstmt.setString(1, dname);
					pstmt.setString(2, loc);
					pstmt.setInt(3, deptno);
					
					int result = pstmt.executeUpdate(); // insert, update, delete : excute
					System.out.println(result > 0 ? deptno + "번 부서 정보 수정 완료" : "검색하신 부서는 없습니다.");
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
