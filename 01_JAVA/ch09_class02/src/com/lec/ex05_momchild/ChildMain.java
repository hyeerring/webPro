package com.lec.ex05_momchild;

public class ChildMain {
	public static void main(String[] args) {
		Child child1 = new Child("첫째 밤이");
		Child child2 = new Child("둘째 진수");
		Child child3 = new Child("셋째 철수");
		
		child1.takeMoney(2000);
		child2.takeMoney(1000);
		child3.takeMoney(1000); // 셋째는 줄 수 없음
	}
}
