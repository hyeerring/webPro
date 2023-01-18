package com.lec.ex09_customer.copy;

public class TestMain {

	public static void main(String[] args) {
		Customer customer1 = new Customer("지우", "010-0000-0000", "서울시 성동구", "01월01일");
//		System.out.println(customer1.infoString());
		System.out.println();
		customer1.buy(500000);
		customer1.buy(510000);

		System.out.println(); // 개행

		Customer customer2 = new Customer("이슬", "010-1111-2222", "경기도 고양시", "02월02일");
//		System.out.println(customer2.infoString());
//		customer2.buy(5000);
		if (customer2 instanceof Customer) { // * if절로 쓰는 이유
			((Customer) customer2).buy(5000);
		}

		System.out.println(); // 개행

		System.out.println("==================== 고객명단 ====================");
		Person[] person = { customer1, customer2 };
		for (Person p : person) {
			System.out.println(p.infoString());

		}
		System.out.println();
		System.out.println("==================== 직원명단 ====================");

		Staff staff1 = new Staff("웅이", "010-3333-3333", "서울시 영등포구", "3월3일", "12월10일", "전산팀");
		System.out.println(staff1.infoString());
	}
}
