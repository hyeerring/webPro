package com.lex.ex04_object;

public class Ex04_HashCord {
	public static void main(String[] args) {

		String str1 = "Hello";
		String str2 = new String("Hello");
		if (str1 == str2) {
			System.out.println("같은 곳을 참조한다.(주소가 같음)");
		} else {
			System.out.println("다른 "
					+ "곳을 참조한다.");
		}
		Card card = new Card('♥', 1);
		System.out.println(card.hashCode());
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}