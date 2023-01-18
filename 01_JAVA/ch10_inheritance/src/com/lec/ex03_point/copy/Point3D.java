package com.lec.ex03_point.copy;

// x, y
//inforPrint(좌표 x = 1, y = 2를 콘솔에 출력)
public class Point3D extends Point {
	private int z;

	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
		System.out.println("매개변수 있는 Point3D 생성자 (함수: x, y, z 값 초기화)");
	}

	@Override
	public void InfoPrint() {
		super.InfoPrint();
		System.out.println("\tz = " + z);
	}

}
