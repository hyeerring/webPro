package com.lex.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex07_SimpleDateFormat {

	public static void main(String[] args) {
//		Date date = new Date(2022, 12, 25, 9, 30);
		Date date = new Date(new GregorianCalendar(2022, 11, 25, 9, 30).getTimeInMillis());
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yy년 MM월 dd일 HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yy-MM-dd(E) a hh:mm:ss");
		SimpleDateFormat sdf4 = new SimpleDateFormat("오늘은 올해의 D번째 날입니다.");
		SimpleDateFormat sdf5 = new SimpleDateFormat("이번주는 올해의 w번째 주입니다.");

		System.out.println(sdf1.format(date));
		System.out.println(sdf2.format(date));
		System.out.println(sdf3.format(date));
		System.out.println(sdf4.format(date));
		System.out.println(sdf5.format(date));
	}

}
