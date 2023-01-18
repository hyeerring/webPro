package com.lec.ex09_customer.copy;

// String Name, String tel, String address, String date
// infoString();
// Person person = new Person("홍길동", "010-0000-0000);	
public class Person {
	private String name;
	private String tel;
	private String address;
	private String date;

	public Person(String name, String tel, String address, String date) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.date = date;
	}

	public String infoString() {
		return "이름: " + name + "\t\t전화번호: " + tel + "\t\t주소: " + address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}