package com.lex.ex02_date;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import com.lex.ex04_object.Friend;

// 오늘 생일인 친구들 출력
public class Ex05_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("김길동", "010-1111-1111", "11-14", "서울시 서대문구"),
				new Friend("이길동", "010-2222-2222", "12-14", "서울시 용산구"),
				new Friend("삼길동", "010-3333-3333", "03-14", "서울시 종로구"),
				new Friend("사길동", "010-4444-4444", "04-14", "서울시 성동구"),
				new Friend("오길동", "010-5555-5555", "05-14", "서울시 강남구") };

		GregorianCalendar now = new GregorianCalendar();
		int month = now.get(Calendar.MONTH) + 1; // 12월
		int day = now.get(Calendar.DAY_OF_MONTH); // 12일
//		String monthStr = month < 10? "0" + month : "" + month;
		String monthStr = month < 10 ? "0" + month : String.valueOf(month);
		String dayStr = day < 10 ? "0" + day : String.valueOf(day);
		String today = month + "-" + day;
		System.out.println(today);

		boolean none = true;
		System.out.println("오늘 생일인 친구를 검색합니다.");
		for (int idx = 0; idx < friends.length; idx++) {
			String birth = friends[idx].getBirth();
			if (today.equals(birth)) {
				System.out.println(friends[idx]);
				none = false;
			} // if

		} // for
		if (none) {
			System.out.println("오늘 생일인 친구가 없습니다.");
		}
	} // main

} // class
