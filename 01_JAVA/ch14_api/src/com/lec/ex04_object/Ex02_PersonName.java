package com.lex.ex04_object;

public class Ex02_PersonName {
	public static void main(String[] args) {
		Person p1 = new Person(9605051234567L);
		Person p2 = new Person(9605051234567L);
		Person p3 = null;
		Person p4 = new Person();
		Friend f = new Friend();

		System.out.println(p1.equals(p2) ? "p1과 p2는 같다." : "p1과 p2는 다르다.");
		System.out.println(p1 == p2 ? "p1과 p2는 같은 주소 참조" : "p1과 p2는 다른 주소 참조");
		System.out.println(p1.equals(p3) ? "p1과 p3는 같다." : "p1과 p3는 다르다.");
		System.out.println(p1.equals(f) ? "p1과 f는 같다." : "p1과 f는 다르다.");
	}

}
