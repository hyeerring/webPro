package com.lec.ex02_human.kid;

// 같은 패키지로 들어가는지 확인
public class Kid {
	private String name;

	public Kid(String name) {
		this.name = name;
		System.out.println("매개변수 있는 Kid 생성자");
	}
}
