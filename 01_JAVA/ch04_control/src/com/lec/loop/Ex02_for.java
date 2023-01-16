package com.lec.loop;

// 결과: 1~20까지의 누적합은 210
// 결과: 1+2+3+ ... +20 = 210
public class Ex02_for {
	public static void main(String[] args) {
		int tot = 0; // 누적합을 위한 변수
		for (int i = 1; i <= 20; i++) {
			tot += i; // tot = tot + i
		}
		System.out.println("1부터 20까지의 누적합은 " + tot);

		int total = 0; // 누적합을 위한 변수
		for (int i = 1; i <= 20; i++) {
			System.out.print(i);
			if (i != 20) {
				System.out.print('+');
			}
			total += i; // total = total + i
		}
		System.out.println("= " + total);

	}
}
