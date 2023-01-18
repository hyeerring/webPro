package com.lec.ex06_member;

// 데이터: id, pw, name, email, address, birth(String으로 작성), gender
// 
// main()함수 내용 : Member member = new Member(“aaa”, “xxx”, “홍길동”, “hong@company.com”,
// “서울 강남구”, “2000-01-01”, ‘M’);
// System.out.println(member.infoString() );

public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private char gender;
	
	public Member() {
	}

	public Member(String id, String pw, String name, String email, String address, String birth, char gender) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	
	public String infoString() {
		String result = "아이디 = " + id;
		result += "\n비밀번호 = " + pw;
		result += "\n이름 = " + name;
		result += "\n이메일 = " + email;
		result += "\n주소 = " + address;
		result += "\n생일 = " + birth;
		result += "\n성별 = " + (gender == 'm' ? "남자" : (gender == 'f' ? "여자" : "무"));
		return result;
	}
	
} // class
