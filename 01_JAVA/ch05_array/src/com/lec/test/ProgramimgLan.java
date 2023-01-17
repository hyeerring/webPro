package com.lec.test;
// {76,45,34,89,100,50,90,93}

// 8개의 값을 1차원 배열로 초기화 하고 값에 합계와 평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시요.

public class ProgramimgLan {
	public static void main(String[] args) {
	
		int[] arr = {76, 45, 34, 89, 100, 50, 90, 93};
		int tot = 0;
		for(int a : arr) {
			System.out.print(a + "\t");
		}
		System.out.println();
		
		for(int temp : arr) {
			tot += temp;
		}
		System.out.printf("합계 = " + tot + "\t" + "평균 = " + ((double)tot / arr.length));
		System.out.println();
		
		int maxIdx = 0, maxi = 0; // 최대값 변수
		int minIdx = 0, mini = 0; // 최소값 변수
		
		for (int idx = 0; idx < arr.length; idx++) {
			if (arr[idx] > maxi) {
				maxi = arr[idx];
				maxIdx = idx;
			}
			if (arr[idx] < mini) {
				mini = arr[idx];
				minIdx = idx;
			}
		}
		System.out.printf("최대값은 = " + maxIdx + "\t" +  "최소값은 = " + minIdx);
		
	} // main
} // class