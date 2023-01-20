package com.lex.ex01_string;

/*
 * 정규표현식
 * 간략 문법
 * 	\d : 숫자와 매치, [0-9]와 동일
 *	\D : 숫자가 아닌 것)
 *	 \w : 영문자나 숫자, [A-Za-z0-9]와 동일
 *	 \W : 영문자나 숫자가 아닌 것
 *  . : 문자
 * \. : '.'
 *  * : 0번 이상 반복
 *  + : 한번 이상 반복
 *  ? : 0번이나 1번 의미
 * {2} : 2회 반복
 * {2,4} : 2~4회 반복
 */

 class Ex03_regex {
	public static void main(String[] args) {
		
		/* 정규표현식 연습장
		 * https://www.regexpal.com/
		 * 
		 * Ex01. IP주소: 111.222.3.444 / 0.0.0.0
		 * ([0-9]{1,3}\.){3}[0-9]{1,3}
		 * 
		 * Ex02. 전화번호 : 02 111 1111 / 02)222.2222 / 010 3333 3333 / 010-4444-4444 / 010.5555.5555
		 * \d{2,3}.?\d{2,3}.?\d{4}
		 * 
		 * Ex03. 주민등록번호 : 950101-1111111 / 9502022222222
		 * \d{2}[0-1]\d[0-3]\d-?[1-4]\d{6}
		 * 
		 * Ex04. 이메일 : java@naver.com / javac@gmail.com / java123@oracle.co.kr
		 * \w+@\w+(\.\w+){1,2}
		 * 소스구현
		 */
		
		String juminNo = "950101-1111111";
		// 특정 정규표현식의 문자열 변경
		System.out.println("주민번호 : " + juminNo.replaceAll("-[1-4][0-9]{6}", "*******"));
		
		String str = "반갑습니다. 010.5555.5555 javac@gmail.com";
		System.out.println("이메일을 지운 str : " + str.replaceAll("\\w+@\\w+(\\.\\w+){1,2}", " "));
		System.out.println("전화번호 삭제된 str: " + str.replaceAll("\\d{2,3}.?\\d{2,3}.?\\d{4}", " "));
	}
	
}
