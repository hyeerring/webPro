package com.lex.ex01_string;

public class Ex09_StringBuffer {
	public static void main(String[] args) {

		String str = "abc";
		StringBuffer strBuffer = new StringBuffer("abc");
		System.out.println("strBuffer의 해쉬코드: " + strBuffer.hashCode());
		strBuffer.append("def");
		System.out.println("append후의 strBuffer: " + strBuffer);
		System.out.println("strBuffer의 해쉬코드: " + strBuffer.hashCode());

		// 해당 숫자의 위치에 해당 문자 추가
		strBuffer.insert(3, "AAA");
		System.out.println("insert후의 strBuffer: " + strBuffer);

		// 앞의 숫자부터 뒤의 숫자 앞까지
		strBuffer.delete(3, 6);
		System.out.println("delete후의 strBuffer: " + strBuffer);

		// 버퍼의 가용크기
		int capacitySize = strBuffer.capacity();
		System.out.println("버퍼의 가용 크기: " + capacitySize);
		strBuffer.append("abcdefghijklnmopqrstuvwxyz1234567890");
		System.out.println("append후의 strBuffer: " + strBuffer);
		System.out.println("많은 문자를 추가한 후의 버퍼의 가용 크기: " + strBuffer.capacity());
	}

}
