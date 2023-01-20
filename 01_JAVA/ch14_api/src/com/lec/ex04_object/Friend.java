package com.lex.ex04_object;

public class Friend {
	private String name;
	private String tel;
	private String birth; // "02.02"
	private String address;
	
	public Friend() {
	}

	public Friend(String name, String tel, String birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
	@Override
	public String toString() {
		// 이름: 김길동  전화번호: 010-1111-2222  생일: 01-15  주소: 서울시 서대문구
		return "[이름] " + name + "  [전화번호] " + tel + "  [생일] " + birth + "  [주소] "+ address;
	}
	
	// getter
	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getBirth() {
		return birth;
	}

	public String getAddress() {
		return address;
	}
	

}
