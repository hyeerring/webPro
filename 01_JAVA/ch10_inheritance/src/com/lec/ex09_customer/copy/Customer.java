package com.lec.ex09_customer.copy;

import cons.Constant;

//String Name, String tel, String address, String date, infoString();
public class Customer extends Person {
	private int sum; // 누적 값 필요
	private int point;
	private boolean vip;

	// 고객 등록 시
	public Customer(String name, String tel, String address, String date) {
		super(name, tel, address, date);
		point = 1000;
		System.out.println(name + "님 반갑습니다.\t\t현재 포인트: " + point);
	}

	// 구매 시
	public void buy(int price) { // c.buy(2000)
		sum += price;
		int tempPoint = (int) (price * Constant.RATE);
		point += tempPoint;

		System.out.println("-------------------- 영수증 --------------------");
		System.out.println(getName() + "님 감사합니다.\n구매금액: " + price + "\t\t누적포인트: " + point);
		if (sum >= Constant.VIPLIMIT) {
			vip = true;
			System.out.println("****************************************");
			System.out.println("축하합니다! VIP고객으로 업그레이드 되셨습니다.");
		}
	}

	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "\t\t누적포인트: " + point;
	}
}
