package com.lec.customer;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CustomerDao {
	public static final int SUCCESS = 1; // 회원가입, 정보 수정 성공 시 리턴 값
	public static final int FAIL = 0; // 실패 시 리턴 값
	public static final int CUSTOMER_NONEXISTENT = 1;
	public static final int CUSTOMER_EXISTENT = 0;
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공시 리턴값
	public static final int LOGIN_FAIL = 0; // 로그인 실패시 리턴값
	
	private static CustomerDao instance = new CustomerDao(); // 자기가 자기 클래스형 객체를 참조
	public static CustomerDao getInstance() {
		return instance;
	}
	private CustomerDao() {}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		// 커넥션 풀의 DataSource 안의 conn 객체를 리턴
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection(); // DataSource안의 conn을 가져오기
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	// 1. 회원가입 시 ID 중복체크
	public int confirmId(String cid) {
		int result = CUSTOMER_EXISTENT; // 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			// 실행결과 1 또는 0
			rs.next();
			int cnt = rs.getInt(1);
			if (cnt == 0) {
				result = CUSTOMER_NONEXISTENT;
			}
		} catch (SQLException e) {
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
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 2. 회원가입
	public int joinCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cBIRTH, cGENDER)" + 
				"    VALUES (?, ?, ?, ?, ?, ?," + 
				"    TO_DATE(?, 'YYYY-MM-DD'), ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCaddress());
			pstmt.setDate(7, dto.getCbirth());
			pstmt.setString(8, dto.getCgender());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "회원가입 성공" : "회원가입 실패");
		} catch (SQLException e) {
			System.out.println("회원가입 실패" + dto);
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 3. 로그인
	public int loginCheck(String cid, String cpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT cID, cPW FROM CUSTOMER WHERE cID=? AND cPW=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			pstmt.setString(2, cpw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = LOGIN_SUCCESS;
			} else {
				result = LOGIN_FAIL;
			}
		} catch (SQLException e) {
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
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 4. cID로 DTO가져오기
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE cID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String cId = cid;
				String cPw = rs.getString("cPw");
				String cName = rs.getString("cName");
				String cTel = rs.getString("cTel");
				String cEmail = rs.getString("cEmail");
				String cAddress = rs.getString("cAddress");
				Date cBirth = rs.getDate("cBirth");
				String cGender = rs.getString("cGender");
//				Timestamp cRdate = rs.getTimestamp("cRdate");

				dto = new CustomerDto(cId, cPw, cName, cTel, cEmail, cAddress, cBirth, cGender);
			}
		} catch (SQLException e) {
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
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	
	// 5. 회원정보수정
	public int modifyCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET" + 
				"    cPW = ?," + 
				"    cNAME = ?," + 
				"    cTEL = ?," + 
				"    cEMAIL = ?," + 
				"    cADDRESS = ?," + 
				"    cBIRTH = ?," + 
				"    cGENDER = ?" + 
				"    WHERE cID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCaddress());
			pstmt.setDate(6, dto.getCbirth());
			pstmt.setString(7, dto.getCgender());
			pstmt.setString(8, dto.getCid());

			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "회원수정 성공" : "회원수정 실패");
		} catch (SQLException e) {
			System.out.println("회원수정 실패" + dto);
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
