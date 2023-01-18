package com.lec.ex05_personinfo;

// name, age, gender를 데이터로 갖고, 데이터 정보를 출력하는 print() 메소더를 갖는 PersonInfo 클래스를 구현하고 main함수를 이용하여 test 구현하시오.
// new PersonInfo("홍길동", 20, m)
// print() 메소드 실행 결과 : 이름=홍길동, 나이=20, 성별=m, main 메소드 안에는 PersonInfo형 객체 인스턴스를 배열로 구현해 봅니다.
public class PersonInfo {
	private String name;
	private int age;
	private char gender; // m 또는 f

	public PersonInfo() {
	}

	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	private void print() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("성별: " + (gender == 'm' ? "남자" : "여자"));
		System.out.println("성별: " + (gender == 'm' ? "남자" : (gender == 'f' ? "여자" : "무")));
	}

	public String infoString() {
//		String result = "이름: " + name + "\n" + "나이: " + age + "성별: " + (gender == 'm' ? "남자" : (gender == 'f' ? "여자" : "무"));
		String result = "이름: " + name;
		result += "\n나이: " + age;
		result += "\n성별: " + (gender == 'm' ? "남자" : (gender == 'f' ? "여자" : "무"));
		return result;
	}

} // class
