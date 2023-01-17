package com.lec.ex;

import java.util.Iterator;

// 배열은 대부분 1차원 배열을 쓴다. cf.다차원 배열
public class Ex05_multiDemension {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 }; // 1차원 배열
		int[][] test = { { 1, 2, 3 }, { 4, 5, 6 } };// 2차원 배열
		test[0][1] = 20;
		// 다차원 배열의 출력
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.printf("test[%d][%d] = %d\n", i, j, test[i][j]);
			} // for - j
		} // for - i
	} // main
} // class
