package com.lex.ex06_wrapper;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("스트링을 정수로 바꾸는 함수: Integer.parseInt(String s)");
		int i = Integer.parseInt("10");
		System.out.println(i);

		System.out.println("정수를 스트링으로 바꾸는 함수: String.valueOf(int i)");
		String monthStr = String.valueOf(12);
		monthStr = "" + 12;
	}

}
