package com.lec.ex09_customer.copy;

//String Name, String tel, String address, String date, infoString();
public class Staff extends Person {
	private String hiredate; // 입사일 ("2022-12-05")
	private String department; // 부서

	public Staff(String name, String tel, String address, String date, String hiredate, String department) {
		super(name, tel, address, date);
		this.hiredate = hiredate;
		this.department = department;
	}

	@Override
	public String infoString() {
		// TODO Auto-generated method stub
		return super.infoString() + "\t\t부서: " + department + "\t\t입사일: " + hiredate;
	}

}
