package com.lec.condition;

// 실행할 때마다 컴퓨터가 난수점수(Random)를 발생하여 학점 출력
public class Ex07_switch_RandomHakjum {
	public static void main(String[] args) {
		// 0 <= Math.random() < 1: 실수 난수
		// 0 <= Math.random() * 100 < 100: 실수 난수
		// 0 <= int(Math.random()* 101)< 101 사이의 정수: 난수
		// System.out.println((int)(Math.random() * 101));
		int score = (int) (Math.random() * 100);
		int temp = (score == 100) ? score - 1 : score;
		switch (score / 10) {
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		case 6:
			System.out.println("D학점");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("F학점");
			break;
		default:
			System.out.println("다시 입력하세요.");
		}
	}
}