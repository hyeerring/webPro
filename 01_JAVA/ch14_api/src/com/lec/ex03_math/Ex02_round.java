package com.lex.ex03_math;

/* Math.ceil(올릴 실수):double값 return
 ex) Math.ceil(9.1) // 10.0
 
 Math.round(반올림 할 실수): long값 return
 ex) Math.round(9.16) // 9
 
 Math.floor(버릴 실수): double값 return
 ex) Math.floor(9.99) // 9.0
 */
public class Ex02_round {
	public static void main(String[] args) {
		System.out.println("소수점에서 올림, 반올림, 버림");
		System.out.println("9.15를 올림: " + Math.ceil(9.15)); // 10.0
		System.out.println("9.15를 반올림: " + Math.round(9.15)); // 9
		System.out.println("9.15를 버림: " + Math.floor(9.15)); // 9.0

		System.out.println("소수점 한자리에서 반올림, 올림, 버림");
		System.out.println("9.15를 올림: " + Math.ceil(9.15 * 10) / 10); // 9.2
		System.out.println("9.15를 반올림: " + Math.round(9.15 * 10) / 10.0); // 9.2
		System.out.println("9.15를 버림: " + Math.floor(9.15 * 10) / 10); // 9.1

		System.out.println("일의 자리에서 반올림, 올림, 버림");
		System.out.println("85를 올림: " + Math.ceil(85 / 10.0) * 10); // 90.0
		System.out.println("85를 반올림: " + Math.round(85 / 10.0) * 10); // 90
		System.out.println("85를 버림: " + Math.floor(85 / 10.0) * 10); // 80.0
	}
}
