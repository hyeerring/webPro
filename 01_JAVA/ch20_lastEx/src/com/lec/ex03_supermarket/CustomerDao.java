package com.lec.ex03_supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// dao는 싱클톤으로 구현
// private 생성자에는 driver로드
public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final static int SUCCESS = 1;
	public final static int FAIL    = 0;
	private static CustomerDao INSTANCE;
	public static CustomerDao getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerDao();
		}
		return INSTANCE;
	}
	
	private CustomerDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 01. 회원가입
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER(CID, CTEL, CNAME)\n" + 
				"    VALUES (SUPERMARKET_CUSTOMER_SQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCtel());
			pstmt.setString(2, dto.getCname());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 01. 회원가입_public int insertCustomer(String ctel, String cname) 
//		public int insertCustomer(String ctel, String cname) {
//			int result = FAIL;
//			Connection        conn  = null;
//			PreparedStatement pstmt = null;
//			String sql = "INSERT INTO CUSTOMER(CID, CTEL, CNAME)\n" + 
//					"    VALUES (SUPERMARKET_CUSTOMER_SQ.NEXTVAL, ?, ?)";
//			try {
//				conn = DriverManager.getConnection(url, "scott", "tiger");
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, "ctel");
//				pstmt.setString(2, "cname");
//				result = pstmt.executeUpdate();
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			} finally {
//				try {
//					if(pstmt != null) pstmt.close();
//					if(conn != null) conn.close();
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//			}
//			return result;
//		}
	
	// 02. 핸드폰 뒷자리 4자리 검색
	public ArrayList<CustomerDto> ctelGetCustomers(String searchTel){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME," + 
				"    (SELECT HIGH + 1 - CAMOUNT FROM CUSTOMER WHERE LEVELNO != 50 AND CID = C.CID) FORLEVELUP" + 
				"    FROM CUSTOMER C, LEVELGRADE" + 
				"    WHERE C.LEVELNO = LEVELGRADE.LEVELNO AND CTEL LIKE '%' || ? ";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchTel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	
	// 03_01. 물품구입
	public int buy(int cid, int price) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER" + 
				"    SET CAMOUNT = CAMOUNT + ?," + 
				"    CPOINT = CPOINT + (? * 0.05)," + 
				"    LEVELNO = (SELECT L.LEVELNO FROM CUSTOMER, LEVELGRADE L" + 
				"               WHERE CAMOUNT + ? BETWEEN LOW AND HIGH AND CID = ?)" + 
				"    WHERE CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, price);
			pstmt.setInt(3, price);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
	
	// 03_02. 물품 구입 후 구매자 정보 출력
	public CustomerDto getcustomer(int cid) {
		CustomerDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME," + 
				"     (SELECT HIGH + 1 - CAMOUNT FROM CUSTOMER WHERE LEVELNO != 50 AND CID = C.CID)  forLevelUp" + 
				"  FROM CUSTOMER C, LEVELGRADE L" + 
				"  WHERE C.LEVELNO = L.LEVELNO AND CID = ?"; 
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
//				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dto = new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forlevelup);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return dto;
	}
	
	// 04_01. 등급 출력
	public ArrayList<String> getLevelNamse(){
		ArrayList<String> levelNames = new ArrayList<String>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT LEVELNAME FROM LEVELGRADE";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				levelNames.add(rs.getString("levelName"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return levelNames;
	}
	
	// 04_02. 고객 등급별 출력
	public ArrayList<CustomerDto> levelNameGetCustomers(String levelName) {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME," + 
				"    (SELECT HIGH + 1 - CAMOUNT FROM CUSTOMER WHERE LEVELNO != 50 AND CID = C.CID) FORLEVELUP" + 
				"    FROM CUSTOMER C, LEVELGRADE" + 
				"    WHERE C.LEVELNO = LEVELGRADE.LEVELNO AND LEVELNAME = ? " + 
				"    ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}
	
	// 05. 전체 출력
	public ArrayList<CustomerDto> getCustomers() {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME," + 
				"    (SELECT HIGH + 1 - CAMOUNT FROM CUSTOMER WHERE LEVELNO != 50 AND CID = C.CID) FORLEVELUP" + 
				"    FROM CUSTOMER C, LEVELGRADE" + 
				"    WHERE C.LEVELNO = LEVELGRADE.LEVELNO" + 
				"    ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new CustomerDto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
		}

	// 06. 회원탈퇴
	public int deleteCustomer(String ctel) {
			int result = FAIL;
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM CUSTOMER WHERE CTEL = ? ";
			try {
				conn = DriverManager.getConnection(url, "scott", "tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ctel);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			return result;
		}

}
