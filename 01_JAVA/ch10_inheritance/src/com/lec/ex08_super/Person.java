package com.lec.ex08_super;

//super.@@ : 부모클래스의 @@
//super() : 부모클래스의 생성자 함수, 함수 내 첫번째 명령이여야 한다.
public class Person {
	private String name;
	private String character;

	public Person() {
		super(); // 부모클래스의 매개변수가 없는 생성자 함수
		System.out.println("매개변수가 없는 Person 생성자");
	}

	public Person(String name, String character) {
		super();
		this.name = name;
		this.character = character;
		System.out.println("매개변수가 두개인 Person 생성자");
	}

	public void intro() {
		System.out.println("* " + name + "은 " + character);
		System.out.println("------------------------------");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

}
