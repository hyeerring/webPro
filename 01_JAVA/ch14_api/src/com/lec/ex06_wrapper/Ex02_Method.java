package com.lex.ex06_wrapper;

import java.util.Iterator;

// java com.lec.ex6_wrapper.Ex02 1 10 20 30 실행
// 들어온 값의 갯수 : 4
// 들어온 값의 합 : 61
public class Ex02_Method {
	public static void main(String[] args) {
		System.out.println("들어온 값의 갯수: " + args.length);
		int total = 0; // 누적변수
		for (int i = 0; i < args.length; i++) {
			total += Integer.parseInt(args[i]);
			System.out.println(args[i]);
		}
		System.out.println("들어온 값의 합: " + total);

	}

}
