package com.lec.ex09_customer;

import cons.Constant;

// name, tel
public class Customer extends Person {
	private String address;
	private int sum; // 구매금액 누적
	private int point; // 포인트 구매 시 0.5 %
	private String date; // 다음주부터는 Date형
	private boolean vip;

	// Customer c = new Customer ("홍길동", "010-0000-0000", "서울시 용산구", "05-05")
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);
		this.address = address;
		this.date = date;
		point = 1000;
		System.out.println(name + "님 반갑습니다. 포인트 1,000점 드렸습니다.");
		// TODO Auto-generated constructor stub
	}

	public void buy(int price) { // c.buy(2000);
		sum += price; // 누적금액에 누적
		int tempPoint = (int) (price * Constant.RATE);
		point += tempPoint; // 포인트 누적

		System.out.println(getName() + "님 감사합니다. \n 구매 금액: " + price + "구매 포인트 : " + point);
		System.out.println("누적 포인트: " + point);
		if (vip == false && sum >= Constant.VIPLIMIT) {
			vip = true;
			System.out.println("****************************************");
			System.out.println("축하합니다! VIP고객으로 업그레이드 되셨습니다.\n앞으로 구매금액의 2% 할인됩니다.");
		} // if
	} // buy

	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "  [주소] " + address + "  [포인트]" + point;
	}
}
