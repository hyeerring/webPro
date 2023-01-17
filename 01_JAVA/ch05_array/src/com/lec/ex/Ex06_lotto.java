package com.lec.ex;

// Math.random()
// 0 < Math.random()*45 < 45: 실수
// 1 < (int)(Math.random()*45+1) < 46: 1 ~ 45까지의 실수
public class Ex06_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int i, j;
		int temp;
		for (i = 0; i < lotto.length; i++) {
			do {
				temp = (int) (Math.random() * 45 + 1);
				for (j = 0; j < i; j++) {
					if (lotto[j] == temp) {
						System.out.println("중복되서 다시 함" + temp);
						break;
					} // if: temp랑 같은 번호가 있을 시 for문을 빠져나감.
				} // for
			} while (i != j);
			lotto[i] = temp;
		}

		// sort: 배열 값을 순서대로 정리
		for (i = 0; i < lotto.length - 1; i++) {
			for (j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
			
		// 발생된 로또 번호 출력
		for (int l : lotto) {
			System.out.print(l + "\t");
		}

	} // main
} // class
