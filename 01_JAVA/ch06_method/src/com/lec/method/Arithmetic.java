package com.lec.method;

// sum(10, 100), sum(100): 함수의 오버로딩
// evenOdd
// abs(-9)

public class Arithmetic { // from부터 to까지 정수 누적 값 return
	public int sum(int from, int to) {
		int result = 0; // 누적변수
		for (int i = from; i <= to; i++) {
			result += i;
		}
		return result;
	}

	public int sum(int to) { // 1부터 to까지의 정수 누적 값 return
		int result = 0;
		for (int i = 1; i <= to; i++) {
			result += i;
		}
		return result;
	}

	public String evenOdd(int value) {
		return value % 2 == 0 ? "짝수입니다." : "홀수입니다.";
	}

	// 절대값을 return. + 접근제한자 생략할 경우 확인
	// 같은 패키지 안에서만 호출 가능
	public static int abs(int value) {
		int result = value >= 0 ? value : -value;
		return result;
	}

} // class
