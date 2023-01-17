package com.lec.Quiz;

//Quiz3) 거스름돈 2680을 500, 100, 50, 10짜리 동전으로 줄 때, 몇개씩 주어야 하나?
public class Quiz03 {
	public static void main(String[] args) {
		int money = 2680;
		int[] coin = { 500, 100, 50, 10 };

		// 일반 for문
		for (int i = 0; i < coin.length; i++) {
			System.out.println(coin[i] + "원 짜리" + money / coin[i] + "개");
			money = money % coin[i];
		}

		// 확장 For
//		for(int coin : coinUnit) {
//		System.out.print(coin + "원짜리 동전 " + (money/coin) + "개\t");
//		money %= coin;
//	}
	}
}
