package com.lec.ex;

import java.util.Iterator;

// return값이 없는 메소드
public class Ex04_voidMethod {
	public static void main(String[] args) {

//		--------------------
//		Hello! Java!
//		~~~~~~~~~~~~~~~~~~~~
//		Hello! Program!
//		====================
//		------------------------------

		printLine();
		System.out.println("Hello! World!");
		printLine('~');
		System.out.println("Hello! Java!");
		printLine('=');
		System.out.println("Hello! Program!");
		Ex04_voidMethod ex = new Ex04_voidMethod(); // 객체 생성
		ex.printLine(21, '*');
		printLine(30);
	}

	private static void printLine() {
		for (int i = 0; i < 20; i++) {
			System.out.print('-');
		}
		System.out.println(); // 기본 라인 그리고 개행
	}

	private static void printLine(char c) {
		for (int i = 0; i < 20; i++) {
			System.out.print(c);
		}
		System.out.println(); // 기본 라인 그리고 개행
	}

	private static void printLine(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print('-');
		}
		System.out.println(); // 기본 라인 그리고 개행
	}

	private void printLine(int cnt, char c) {
		for (int i = 0; i < cnt; i++) {
			System.out.print(c);
		}
		System.out.println();
	}

} // class
