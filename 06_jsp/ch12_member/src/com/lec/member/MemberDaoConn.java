package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDaoConn {
	public static final int SUCCESS = 1; // 회원가입, 정보 수정 성공 시 리턴 값
	public static final int FAIL = 0; // 실패 시 리턴 값
	public static final int MEMBER_NONEXISTENT = 1; // 사용 가능한 ID일 때 리턴값
	public static final int MEMBER_EXISTENT = 0; // 중복된 ID일 때 리턴값
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공 시
	public static final int LOGIN_FAIL_PW = 0; // 로그인 시 pw 오류일 때 리턴 값
	public static final int LOGIN_FAIL_ID = -1; // 로그인 시 id 오류일 때 리턴 값


	// 싱글톤
//	private static MemberDaoConn instance; // 자기 자신이 자기 클래스형 객체를 참조
//	private static MemberDao instance = new MemberDao();
//	public static MemberDaoConn getInstance() {
//		if (instance == null) {
//			instance = new MemberDaoConn();
//		}
//		return instance;
//	};

//	private MemberDaoConn() {
//		try {
//			Class.forName(driver);
//		} catch (ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//	}

	// Connection 객체를 return
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
	// public int confirmId(String id)
	public int confirmId(String id) {
		int result = MEMBER_EXISTENT; // 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			// primary 키로 검색하는 경우 실행결과 1 또는 0
			if (rs.next()) {
				// 중복된 id의 경우
				result = MEMBER_EXISTENT;
			} else {
				// 사용 가능한 아이디
				result = MEMBER_NONEXISTENT;
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
	// public int joinMember(MemberDto dto)
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER "
				+ "		(ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE)"
				+ "     	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getEmail());
			pstmt.setDate(9, dto.getBirth());
			pstmt.setString(10, dto.getAddress());

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
	// public int loginCheck(String id, String pw)
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_ID;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT ID, PW FROM MEMBER WHERE ID = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// id 일치
				String dbPw = rs.getString("pw");
				if (dbPw.equals(pw)) {
					// pw 일치
					result = LOGIN_SUCCESS;
				} else {
					// pw 불일치
					result = LOGIN_FAIL_PW;
				}
			}
			// 초기화 값이 LOGIN_FAIL_ID이기 때문에 생략 가능
//			  else {
//				// id 불일치
//				result = LOGIN_FAIL_ID;
//			}
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

	// 4. ID로 DTO 가져오기
	// 로그인 성공 시 session에 setAttribute
	// public MemberDto getMember(String id)
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");
				String address = rs.getString("address");
				Timestamp rdate = rs.getTimestamp("rdate");

				dto = new MemberDto(id, pw, name, phone1, phone2, phone3, gender, email, birth, address, rdate);
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
	// public int modifyMember(MemberDto dto)
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " UPDATE MEMBER SET PW = ?," + 
				"        NAME = ?," + 
				"        PHONE1 = ?," + 
				"        PHONE2 = ?," + 
				"        PHONE3 = ?," + 
				"		 GENDER = ?," +
				"        EMAIL = ?," + 
				"        BIRTH = ?," + 
				"        ADDRESS = ?" + 
				"        WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone1());
			pstmt.setString(4, dto.getPhone2());
			pstmt.setString(5, dto.getPhone3());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getEmail());
			pstmt.setDate(8, dto.getBirth());
			pstmt.setString(9, dto.getAddress());
			pstmt.setString(10, dto.getId());

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
