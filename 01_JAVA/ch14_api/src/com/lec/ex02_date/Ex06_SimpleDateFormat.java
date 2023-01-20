package com.lex.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex06_SimpleDateFormat {
	public static void main(String[] args) {
	Date nowDate = new Date();
	Calendar nowCal = Calendar.getInstance();
	GregorianCalendar nowGc = new GregorianCalendar();
	
	/*
	 * yyyy: 년도 4자리
	 * yy : 년도 2자리
	 * MM : 01월
	 * M : 1월
	 * dd : 01일
	 * d : 1일
	 * E : 요일
	 * a : 오전/오후
	 * H : 24시
	 * h : 12시
	 * m : 분
	 * s : 초
	 * W : 이번 월에 몇번째 주인지
	 * w : 이번 년도의 몇 번째 주인지
	 * D : 올해의 몇번째 날인지
	 */
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a h시 m분");
	String dateStr = sdf.format(nowDate);
	String calStr = sdf.format(nowCal.getTime());
	String grStr = sdf.format(nowGc.getTime());
	System.out.println(dateStr);
	System.out.println(calStr);
	System.out.println(grStr);
}

}
