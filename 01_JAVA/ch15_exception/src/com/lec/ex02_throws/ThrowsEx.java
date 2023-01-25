package com.lec.ex02_throws;

public class ThrowsEx {

	public ThrowsEx() throws Exception {
		actionC();
	}

	private void actionC() throws Exception {
		System.out.println("actionC 전반부");
		actionB();
		System.out.println("actionC 후반부");

	}

	private void actionB() throws Exception {
		System.out.println("actionB 전반부");
//		try {
		actionA();
//		} catch (Exception e) {
//			System.out.println("예외 메세지: " + e.getMessage());
//		}
		System.out.println("actionB 후반부");

	}

	private void actionA() throws Exception {
		System.out.println("actionA 전반부");
		int[] arr = { 0, 1, 2 };
//		try {
		System.out.println(arr[3]);
//		} catch (Exception e) {
//			System.out.println("예외 메세지: " + e.getMessage());
//		}
		System.out.println("actionA 후반부");

	}

}
