package com.lec.quiz;

// subject
// print() 재정의
public class Gangsa extends Person {
	private String subject;
	public static int count = 0;

	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setNo("teacher" + (++count));
	}

	@Override
	public String print() {
		System.out.print("(번호) " + getNo() + "\t");
		return super.print() + "\t(과목) " + subject;
	}

}
