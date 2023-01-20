package com.lex.ex04_object;

public class Ex01_FriendMain {

	public static void main(String[] args) {
		Friend[] friends = {new Friend("김길동", "010-1111-1111", "01-15", "서울시 서대문구"),
				new Friend("이길동", "010-2222-2222", "02-15", "서울시 용산구"),
				new Friend("삼길동", "010-3333-3333", "03-15", "서울시 종로구"),
				new Friend("사길동", "010-4444-4444", "04-15", "서울시 성동구"),
				new Friend("오길동", "010-5555-5555", "05-15", "서울시 강남구")};
	
		// 이름: 김길동	전화번호: 010-1111-2222	생일: 01-15	주소: 서울시 서대문구
	
		System.out.println(friends[0]);
			
	} // main

} // class
