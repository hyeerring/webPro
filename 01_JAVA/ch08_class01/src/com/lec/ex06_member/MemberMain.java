package com.lec.ex06_member;

public class MemberMain {
	public static void main(String[] args) {
		
	Member member = new Member("aaa", "xxx", "홍길동", "hong@company.com", "서울시 강남구", "2000-01-01", 'm');
	System.out.println(member.infoString());

	}
}
