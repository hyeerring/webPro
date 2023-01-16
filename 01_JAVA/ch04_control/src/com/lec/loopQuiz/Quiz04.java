package com.lec.loopQuiz;
//(Quiz 4) 다음과 같은 출력형식의 구구단을 출력하는 프로그램을 구현해 보자(9x9)

// 2*1=2	3*1=3	4*1=4	5*1=5	6*1=6	7*1=7	8*1=8	9*1=9	
// 2*2=4	3*2=6	4*2=8	5*2=10	6*2=12	7*2=14	8*2=16	9*2=18	

public class Quiz04 {
	public static void main(String[] args) {

		for (int a = 1; a <= 9; a++) {
			for (int b = 1; b <= 9; b++) {
				System.out.print(b + "x" + a + "=" + (a * b) + "\t");
				if (b == 9) {
					System.out.println();
					System.out.println();
				}
			}
		}
	}
}
