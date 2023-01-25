package com.lec.ex03_excetions;

import java.util.Date;
import java.util.GregorianCalendar;

public class Ex02_NullPoint {
	public static void main(String[] args) {
		
	Friend kim = new Friend("김길동", "010-1111-1111", new Date(new GregorianCalendar(2000,01,01).getTimeInMillis()));
	System.out.println(kim);
	Friend lee = new Friend("이길동", "010-2222-2222");
	System.out.println(lee);
	

	}

}
