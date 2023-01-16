package com.lec.condition;

public class Ex01_if {
	public static void main(String[] args) {
		int score = 65;
		if (score >= 90) {
			System.out.println("참 잘했습니다!");
		} else if (score >= 70) {
			System.out.println("좋아요!");
		} else if (score >= 50) {
			System.out.println("조금 더 노력하세요.");
		} else {
			System.out.println("재시험입니다.");
		}
		System.out.println("Done");
	}
}
