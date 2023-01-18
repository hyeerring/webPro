package com.lec.ex09_customer;

// name, tel, infoString
public class Staff extends Person {
	private String hiredate; // 입사일("2020-05-05"), 다음주부터 Date형
	private String department; // 부서

	// Staff s = new Staff("홍사원", "010-9999-9999", "2022-12-31", "전산실")

	public Staff(String name, String tel, String hiredate, String department) {
		super(name, tel);
		this.hiredate = hiredate;
		this.department = department;
	}

	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "  [부서] " + department + "  [입사일] " + hiredate;
	}

}
