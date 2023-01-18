package com.lec.ex09_customer;

// Person person = new Person("홍길동", "010-0000-0000);	
public class Person {
	private String name;
	private String tel;

	public Person(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}

	public String infoString() {
		return "[이름] " + name + "  [전화번호] " + tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
