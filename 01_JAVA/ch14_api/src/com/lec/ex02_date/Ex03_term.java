package com.lex.ex02_date;

import java.util.Date;
import java.util.GregorianCalendar;

// 두 시점 계산
public class Ex03_term {
	public static void main(String[] args) {
		Date now = new Date(); // 지금
		Date checkOut = new Date(new GregorianCalendar(2022,10,28).getTimeInMillis()); // 대출시점
		long nowMillis = now.getTime(); // 1970.01.01 ~ now까지의 밀리세컨
		long checkMillis = checkOut.getTime();
		
//		GregorianCalendar now = new GregorianCalendar();
//		long nowMillis = now .getTimeInMillis(); // 1970.01.01 ~ now 까지의 Millisec
//		GregorianCalendar checkOut = new GregorianCalendar(2022, 10, 28 , 9, 30); // 대출시점: 22년 11월 28일 9시 30분
//		long checkOutMillis = checkOut.getTimeInMillis(); // 1970.01.01 ~ checkOut 까지의 Millisec
//		
		int day = (int)(nowMillis - checkMillis)/(1000*60*60*24);
		System.out.println("대여기간: " + day);
		
	}
		
}
