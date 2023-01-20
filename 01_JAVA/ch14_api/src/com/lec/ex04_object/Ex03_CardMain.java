package com.lex.ex04_object;

import java.util.Random;

public class Ex03_CardMain {

	public static void main(String[] args) {
		Card[] cards = { new Card('♥', 1), new Card('♥', 2), new Card('♥', 3), new Card('♥', 4), new Card('♥', 5),
				new Card('♥', 6), new Card('♥', 7), new Card('♥', 8), new Card('♥', 9), new Card('♥', 10),
				new Card('♥', 11), new Card('♥', 12), new Card('♥', 13), };
		for (Card card : cards) {
			System.out.println(card);
		} // for
			// 임의로 뽑힌 카드와 배열안의 카드를 비교
		Random ran = new Random();
		char[] kinds = { '♥', '◆', '♠', '♣' };
		Card randomCard = new Card(kinds[ran.nextInt(4)], ran.nextInt(13) + 1);
		System.out.println("임의로 뽑힌 " + randomCard);
//		boolean none = true;
		int i;
		for (i = 0; i < cards.length; i++) {
			if (cards[i].equals(randomCard)) {
				System.out.println(i + "번째 카드와 일치합니다.");
				break;
			} // if
		} // for
		// i == cards.length: 일치된 카드가 없는 것
		// i != cards.length: 일치된 카드가 없는 것

		if(i == cards.length) {
			System.out.println("일치하는 카드가 없습니다.");
		}
		
//		중복된 카드가 있을때 사용		
//		if(none) {
//			System.out.println("일치하는 카드가 없습니다.");
//		}

	}// main
}
