package com.lec.ex;

// 비트연산자 &(and), |(or), ^(XOR:서로 다른 값일때만 1)
public class Ex07 {
	public static void main(String[] args) {
		int n1 = 10; // 0~ 01010
		int n2 = 6; // 0~ 00110
		// ---------------------
		// &: 0~ 00010 -> 2
		// |: 0~ 01110 -> 14
		// ^: 0~ 01100 -> 12

		System.out.println("n1&n2는 " + (n1 & n2));
		System.out.println("n1&n2는 " + (n1 | n2));
		System.out.println("n1&n2는 " + (n1 ^ n2));
	}
}
