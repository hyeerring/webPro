package com.lex.ex01_string;

public class Ex02_StringApiMethod {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = "    ja  va    ";

		// concat(): + 한 값을 return
		System.out.println("1. " + str1.concat(str2)); // 1. abcXabcabcXabc

		// substring(): 호출된 숫자 위치 글씨부터 끝까지 추출
		System.out.println("2. " + str1.substring(3)); // 2. Xabc

		// substring( , ): 호출된 숫자 위치 글씨부터 호출된 숫자 앞까지
		System.out.println("3. " + str1.substring(3, 5)); // 3. Xa

		// length(): 문자열 길이
		System.out.println("4. " + str1.length()); // 4. 7

		// toUpperCase(): 대문자로 변환
		System.out.println("5. " + str1.toUpperCase()); // 5. ABCXABC

		// toLowerCase(): 소문자로 변환
		System.out.println("6. " + str1.toLowerCase()); // 6. abcxabc

		// charAt(): 호출된 위치의 문자
		System.out.println("7. " + str1.charAt(3)); // 7. X

		// indexOf(): 첫번째 해당 문자의 인덱스
		System.out.println("8. " + str1.indexOf('b')); // 8. 1

		// lastIndexOf(): 마지막 문자 인덱스
		System.out.println("9. " + str1.lastIndexOf('b')); // 9. 5

		// indexOf( , ): @번째 나오는 문자의 인덱스
		String str4 = "abcXabcXabcXabcXabcXabc";
		System.out.println("10. " + str4.indexOf('b', 6)); // 10. 5

		// indexOf(" "): 처음 나오는 해당 문자열의 인덱스
		System.out.println("11. " + str4.indexOf("cXa")); // 11. 2

		// indexOf( , ): @번째 나오는 문자의 인덱스
		System.out.println("12. " + str4.indexOf("cXa", 9)); // 12. 10

		// indexOf(): 없을 경우 -1
		System.out.println("13. " + str4.indexOf('z')); // 13. -1

		// equals(): string이 같은지 비교
		System.out.println("14. " + str1.equals(str2)); // 14. true

		// equalsIgnoreCase(): 대소문자 구별없이 비교
		System.out.println("15. " + str1.equalsIgnoreCase("abcxabc")); // 15. true

		// trim(): 앞 뒤 스페이스 제거
		System.out.println("16. " + str3.trim()); // 16. ja va

		// replace( , ): 해당 문자, 문자열을 변경
		System.out.println("17. " + str4.replace("abc", "change")); // 17. changeXchangeXchange ...

		System.out.println("str1: " + str1);
		System.out.println("str2: " + str2);
		System.out.println("str3: " + str3);
		System.out.println("str4: " + str4);

	}

}
