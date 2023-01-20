package com.lex.ex04_object;

// (1)implement Cloneable
// (2)복제 메소드 clone을 오버라이드
public class RectangleMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r1 = new Rectangle();
		r1.setHeight(5);
		r1.setWidth(10);
		Rectangle r2 = (Rectangle) r1.clone(); // 주소 복사
		System.out.println("r1: " + r1);
		System.out.println("r2: " + r2);

		if (r1.equals(r2)) {
			System.out.println("같은 내용의 사각형 객체");
		} else {
			System.out.println("다른 내용의 사각형 객체");
		}
		if (r1 == r2) {
			System.out.println("복제가 아닌 복사");
		} else {
			System.out.println("다른 주소");
		}
		if (r1 != r2 && r1.equals(r2)) {
			System.out.println("복제 성공");
		} else {
			System.out.println("복제 실패");
		}
	}

}
