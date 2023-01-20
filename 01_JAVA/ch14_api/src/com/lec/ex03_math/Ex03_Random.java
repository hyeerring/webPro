package com.lex.ex03_math;

import java.util.Random;

// 0 <= Math.random() < 1의 double 난수
// 0 <= (int)(Math.random() * 45) < 45
// 1 <= (int)(Math.random() * 45) + 1 < 45
public class Ex03_Random {
	public static void main(String[] args) {
		System.out.println("1~45까지 정수 난수: " + (int)(Math.random() * 45)+1);
		Random random = new Random();
		System.out.println("int 난수: " + random.nextInt()); // 정수 난수
		System.out.println("double 난수: " + random.nextDouble()); // Math.random()과 유사
		System.out.println("true/false 난수: " + random.nextBoolean()); // Boolean 난수
		System.out.println("0 ~ 100까지의 정수 난수: " + random.nextInt(101));
		System.out.println("0 ~ 45까지의 정수 난수: " + random.nextInt(46));
		System.out.println();
		System.out.println("0 ~ 45까지의 정수 난수: " + (random.nextInt(46) + 1));
		System.out.println("가위(0), 바위(1), 보(2): " + random.nextInt(3));
	}
}
