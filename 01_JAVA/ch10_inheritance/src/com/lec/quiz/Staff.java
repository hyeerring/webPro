package com.lec.quiz;

// department
// print() 재정의
public class Staff extends Person {
	private String department;
	public static int count = 0;

	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		setNo("staff" + (++count));
	}

	@Override
	public String print() {
		System.out.print("(번호) " + getNo() + "\t");
		return super.print() + "\t(부서) " + department;
	}

}
