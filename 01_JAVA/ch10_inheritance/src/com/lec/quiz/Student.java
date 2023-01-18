package com.lec.quiz;

// ban
// print() 재정의
public class Student extends Person {
	private String ban;
	public static int count = 0;

	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setNo("Student" + (++count));
	}

	@Override
	public String print() {
		System.out.print("(번호) " + getNo() + "\t");
		return super.print() + "\t(반) " + ban;
	}

}
