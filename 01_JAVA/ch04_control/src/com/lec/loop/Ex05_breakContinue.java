package com.lec.loop;

//break
//continue
public class Ex05_breakContinue {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			if (i == 3)
//			break; //반복문 블럭을 빠져나
				continue; // 증감식으로 올라감
			System.out.println(i);
		}
	}
}
