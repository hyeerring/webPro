package com.lec.ex03_point.copy;

public class TestMain {

	public static void main(String[] args) {
		Point point1 = new Point();
		Point point2 = new Point(1, 2);

		point1.InfoPrint();
		System.out.println(); // 개행
		point2.InfoPrint();

		System.out.println(); // 개행
		System.out.println("------------------------------");

		Point3D point3d = new Point3D(10, 20, 30);
		point3d.InfoPrint();
	}
	// sysout을 String으로 초기화
	// git 참고
}
