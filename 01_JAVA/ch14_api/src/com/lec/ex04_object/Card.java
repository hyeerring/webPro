package com.lex.ex04_object;

// new Card('♥', 6)
public class Card {
	private char kind; // ♥ ◆ ♠ ♣
	private int num; // 1 ~ 13

	public Card() {

	}

	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}

	@Override
	public String toString() {
		// 객체의 정보를 return
		return "카드: " + kind + num; // 카드: ♥ 6
	}

	@Override
	public boolean equals(Object obj) {
		// card.equals(comCard)
		// card가 this. comCard가 obj
		// obj가 null이 아니고 obj가 Card타입 객체인지 확인 후 kind와 num을 비교

		// if (obj != null && obj instanceof Card) {
		if (obj != null && obj.getClass() == getClass()) {
			// kind와 num 비교 결과 return
			Card other = (Card) obj;
			boolean KindChk = kind == other.kind;
			boolean numChk = num == other.num;
			return (KindChk) && (numChk);
		} else {
			return false;
		}
	}
}
