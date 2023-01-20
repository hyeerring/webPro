package com.lex.ex04_object;

public class Person {
	private long socialNo;

	public Person() {
	}

	public Person(long socialNo) {
		this.socialNo = socialNo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "주민번호는 : " + socialNo;
	}

	@Override
	public boolean equals(Object obj) {
		// p1.equals(p2): p1이 this. p2가 return
		// this의 주민번호와 obj의 주민번호가 같은지 다른지 여부를 return
		if (obj != null && obj instanceof Person) {
			return socialNo == ((Person) obj).socialNo;
		} else {
			return false;
		}

	}

}
