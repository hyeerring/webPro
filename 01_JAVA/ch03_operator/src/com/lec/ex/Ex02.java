package com.lec.ex;

// 증감연산자: ++(하나 증가) --(하나 감소)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; // n1을 1증가하고 n2에 할당
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = n1++; // n1값을 n2에 할당한 후 1증가
		// ++n1; 요즘 이렇게 많이 쓰는 추세
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = --n1;
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = n1--;
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
	}
}
