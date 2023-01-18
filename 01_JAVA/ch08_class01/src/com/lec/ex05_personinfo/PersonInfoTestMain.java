package com.lec.ex05_personinfo;

public class PersonInfoTestMain {
	public static void main(String[] args) {
		int i = 10;
//		int[] arr = { 1, 2, 3 };
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		for (int a : arr) { // 확장 for문
			System.out.println(a);
		}

		PersonInfo p1 = new PersonInfo("홍길동", 30, 'm');
//		PersonInfo[] person = { new PersonInfo("홍길동", 25, 'f'), new PersonInfo("홍길순", 25, 'f') };
		PersonInfo[] person = new PersonInfo[2];
		person[0] = p1;
		person[1] = new PersonInfo("홍길동", 30, 'm');

//		일반 for문
//		for (int idx = 0; idx < person.length; idx++) {
//			System.out.println(person[idx].infoString());
//		}

//		확장 for문
		for (PersonInfo p : person) {
			System.out.println(p.infoString());
		}
	}
}
