package com.lec.Quiz;
// 배열에 담긴 값을 더하는 프로그램을 작성

// int[] arr =  { 10, 20, 30, 40, 50}  

public class Quiz01 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		int tot = 0;

		// 일반 For문
//		for (int idx = 0; idx < arr.length; idx++) {
//			tot += arr[idx];
//		}

		// 확장 For문
		for (int temp : arr) {
			tot += temp;

		}
		System.out.println(tot);
	}
}
