package com.lex.ex01_string;

public class Ex08_StringMemoryWaste {

	public static void main(String[] args) {
		String str = "Hello, java";
		// str의 주소출력(X) -> 해쉬코드로 대체
		System.out.println("str의 해쉬코드: " + str.hashCode());
		str = "Hello";
		System.out.println("변경 후의 str의 해쉬코드: " + str.hashCode());
	}

}
