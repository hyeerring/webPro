package com.lec.ex03_supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMarkerMng {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		Scanner scanner = new Scanner(System.in);
		String fn;
		ArrayList<CustomerDto> customers;
		
		do {
			System.out.println("1:회원가입 | 2:핸드폰 뒷자리 회원검색 | 3:물품구매 | 4:등급별 출력 | 5:전체회원 조회 | 6:탈퇴");
			fn = scanner.next();
			switch (fn) {
			case "1":
				System.out.println("======= 회원 가입 =======");
				System.out.print("전화번호를 입력하세요: ");
				String ctel = scanner.next();
				System.out.print("이름을 입력하세요: ");
				String cname = scanner.next();
				int result = dao.insertCustomer(new CustomerDto(0, ctel, cname, 0, 0, null, 0));
				System.out.println(result == CustomerDao.SUCCESS ? cname + "님 환영합니다. 포인트 1000점 적립되었습니다." : "회원등록이 실패했습니다.");
				System.out.println(); // 개행
				break;

			case "2":
				System.out.println("======= 회원 조회 =======");
				System.out.print("검색할 전화번호를 입력하세요(뒷 4자리 또는 전화번호 전체): ");
				String searchTel = scanner.next();
				customers = dao.ctelGetCustomers(searchTel);
				if (customers.isEmpty()) {
					System.out.println("검색결과가 없습니다.");
				} else {
					System.out.println("고객번호\t전화번호\t이름\t포인트\t누적액\t등급\t등급업에 필요한 금액");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
					System.out.println(); // 개행
				}
				break;
				
			case "3":
				System.out.println("======= 물품구매 =======");
				System.out.print("고객 ID: ");
				int cid = scanner.nextInt();
				System.out.print("구매 금액: ");
				int price = scanner.nextInt();
				result = dao.buy(cid, price);
				if (result == CustomerDao.SUCCESS) {
					System.out.println("======== 영수증 ========");
					CustomerDto customer = dao.getcustomer(cid);
					System.out.println("고객번호\t전화번호\t이름\t포인트\t누적액\t등급\t등급업에 필요한 금액");
					System.out.println(customer);
				}
				break;
				
			case "4":
				System.out.println("===== 등급별 조회 =====");
				System.out.print("검색할 등급" + dao.getLevelNamse() + "를 입력하세요: ");
				String levelName = scanner.next();
				customers = dao.levelNameGetCustomers(levelName);
				if (customers.isEmpty()) {
					System.out.println("검색결과가 없습니다.");
				} else {
					System.out.println("고객번호\t전화번호\t이름\t포인트\t누적액\t등급\t등급업에 필요한 금액");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
					System.out.println(); // 개행
				}
				break;
				
			case "5":
				System.out.println("===== 전체회원 조회 =====");
				customers = dao.getCustomers();
				if (customers.isEmpty()) {
					System.out.println("검색결과가 없습니다.");
				} else {
					System.out.println("고객번호\t전화번호\t이름\t포인트\t누적액\t등급\t등급업에 필요한 금액");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
					System.out.println(); // 개행
				}
				break;
				
			case "6":
				System.out.println("======= 회원 탈퇴 =======");
				System.out.print("탈퇴할 회원의 전화번호를 입력하세요: ");
				ctel = scanner.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result == CustomerDao.SUCCESS ? "삭제 완료되었습니다." : "삭제가 불가합니다.");
				break;
			}
			
		} while (fn.equals("1")||fn.equals("2")||fn.equals("3")||fn.equals("4")||fn.equals("5")||fn.equals("6"));
		System.out.println("===== 프로그램 종료 =====");
		
	} // main
} // class
