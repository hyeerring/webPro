package com.lex.ex04_object;

public class Ex05_Point3DMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D();
		p1.setX(5.5);
		p1.setY(10.0);
		p1.setZ(5.0);
		Point3D p2 = (Point3D) p1.clone();
		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2);

		if (p1.equals(p2)) {
			System.out.println("p1과 p2는 같은 내용의 객체");
		} else {
			System.out.println("p1과 p2는 다른 내용의 객체");
		}

		if (p1 == p2) {
			System.out.println("p1과 p2는 같은 주소를 참조");
		} else {
			System.out.println("p1과 p2는 다른 주소를 참조");
		}

		if (p1 != p2 && p1.equals(p2)) {
			System.out.println("복제 성공");
		} else {
			System.out.println("복제 실패");
		}
	} // main
} // class
