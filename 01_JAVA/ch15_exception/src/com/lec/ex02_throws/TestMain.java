package com.lec.ex02_throws;

public class TestMain {

	public static void main(String[] args) {
		try {
			new ThrowsEx();
		} catch (Exception e) {
			System.out.println("예외 메세지: " + e.getMessage());
		}

	}

}
