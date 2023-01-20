package com.lex.ex03_math;

public class Ex01_Math {

	public static void main(String[] args) {
		int a = 2;
		int b = 10;
		// pow(a, b): a의 b승
		System.out.println("a의 b승: " + (int) Math.pow(a, b));
		// abs(a): a의 절대 값
		System.out.println("-9의 절대 값: " + Math.abs(-9.9));
		// a와 b 중 최소값
		System.out.println("a와 b중 최소 값 " + Math.min(a, b));
		// a와 b 중 최대값
		System.out.println("a와 b중 최대 값 " + Math.max(a, b));
		// Math의 final 변수
		System.out.println("PI = " + Math.PI);
	}

}