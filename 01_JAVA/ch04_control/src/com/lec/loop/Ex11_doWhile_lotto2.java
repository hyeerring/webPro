package com.lec.loop;

import java.util.Scanner;

// 컴퓨터가 발생한 로또 난수를 맞추기
public class Ex11_doWhile_lotto2 {
	public static void main(String[] args) {
		int lotto, su; // 컴퓨터 로또번호와 사용자로부터 입력받은 수
		int min = 1, max = 45;
		Scanner scanner = new Scanner(System.in);
		lotto = (int) (Math.random() * 45 + 1); // 로또번호
		do {
			System.out.printf("로또 번호를 맞추어 보세요.(%d~%d): ", min, max);
			su = scanner.nextInt();
			if (su < min || su > min) {
				System.out.println("주어진 범위를 벗어났습니다.");
			}
			if (su > lotto) {
				max = su - 1;
				// System.out.println(su + " 보다 작은 수를 도전하세요.");
			} else if (su < lotto) {
				min = su + 1;
//				System.out.println(su + " 보다 큰 수를 도전하세요.");
			}
		} while (su != lotto);
		System.out.println(su + " 정답입니다.");
	}
}
