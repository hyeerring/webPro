package com.lec.ex03_supermarket;

import java.util.ArrayList;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		int result;
		ArrayList<CustomerDto> custmors;
		
//		System.out.println("1. 회원가입");
//		System.out.println("------------------------------");
//		String ctel = "01022223333";
//		String cname = "진";
//		result = dao.insertCustomer(new CustomerDto(0, ctel, cname, 0, 0, null, 0));
//		System.out.println(result == CustomerDao.SUCCESS ? cname + "님 환영합니다. 포인트 1000점 적립되었습니다." : "회원등록이 실패했습니다.");
	
		System.out.println("2. 핸드폰 번호로 회원 조회");
		System.out.println("------------------------------");
		String searchTel = "3333";
		ArrayList<CustomerDto> dtos = dao.ctelGetCustomers(searchTel);
		if (dtos.isEmpty()) {
			System.out.println("검색결과가 없습니다.");
		} else {
			System.out.println("고객번호\t전화번호\t이름\t포인트\t누적액\t등급\t등급업에 필요한 금액");
			for (CustomerDto d : dtos) {
				System.out.println(d);
			}
		}
//		
//		System.out.println("3. 물품구매");
//		System.out.println("------------------------------");
//		result = dao.buy(2, 25000);
//		if (result == CustomerDao.SUCCESS) { // 물품 구매가 성공하면 성공메세지와 함께 고객 정보 출력
//			CustomerDto customer = dao.getcustomer(2);
//			System.out.println("======== 구매감사합니다. ========");
//			System.out.println("고객번호\t전화번호\t이름\t포인트\t누적액\t등급\t등급업에 필요한 금액");
//			System.out.println(customer);
//		} else {
//			System.out.println("고객번호가 유요하지 않습니다.");
//		}
		
		System.out.println("4. 고객 등급별 조회");
		System.out.println("------------------------------");
		System.out.println("고객레벨: " + dao.getLevelNamse());
		String levelName = "VIP";
		custmors = dao.levelNameGetCustomers(levelName);
		if (dtos.isEmpty()) {
			System.out.println("검색결과가 없습니다.");
		} else {
			System.out.println("고객번호\t전화번호\t이름\t포인트\t누적액\t등급\t등급업에 필요한 금액");
			for (CustomerDto d : custmors) {
				System.out.println(d);
			}
		}
		
		System.out.println("5. 전체출력");
		System.out.println("------------------------------");
		custmors = dao.getCustomers();
		if (dtos.isEmpty()) {
			System.out.println("검색결과가 없습니다.");
		} else {
			System.out.println("고객번호\t전화번호\t이름\t포인트\t누적액\t등급\t등급업에 필요한 금액");
			for (CustomerDto d : custmors) {
				System.out.println(d);
			}
		}
		
		System.out.println("6. 회원탈퇴");
		System.out.println("------------------------------");
		String ctel = "01022223333";
		result = dao.deleteCustomer(ctel);
		System.out.println(result == CustomerDao.SUCCESS ? "삭제 완료되었습니다." : "삭제가 불가합니다.");
		
	} // main
} // class
