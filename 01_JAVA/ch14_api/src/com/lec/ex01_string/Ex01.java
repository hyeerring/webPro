package com.lex.ex01_string;

// new 연산자를 사용하지 않고 " "를 사용한 문자열 상수는 heap 메모리 영역에 string 객체가 생성된다.
// 이미 존재하는 문자열 상수를 사용한다면 이미 생성된 문자열을 공유한다.
public class Ex01 {
	public static void main(String[] args) {

		int i = 10;
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		
		if (str1 == str2) {
			System.out.println("str1과 str2는 같은 주소를 참조");
		} else {
			System.out.println("str1과 str2는 다른 주소를 참조");
		}
		System.out.println(str1 == str3 ? "str1과 str3은 같은 주소" : "str1과 str3은 다른 주소");
		str2 = "Hello java";
		System.out.println(str1 == str2 ? "str1과 str2는 수정 후 같은 주소 참조" : "str1과 str2는 수정 후 다른 주소 참조");
		System.out.println("str1 : " + str1);
		System.out.println("Str2 : " + str2);
	}

}
