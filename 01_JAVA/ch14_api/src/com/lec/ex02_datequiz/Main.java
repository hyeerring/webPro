package com.lex.ex02_datequiz;

public class Main {

	public static void main(String[] args) {
		Sawon[] employee = {new Sawon("220001","김길동", Sawon.COMPUTER),
				new Sawon("220002","이길동", Sawon.PLANNING),
				new Sawon("220003","삼길동", Sawon.DESIGN),
				new Sawon("220004","사길동", Sawon.ACCOUNTING, 2022, 12, 15),
				new Sawon("220005","오길동", Sawon.HUMANRESOURCES, 2020, 02, 02)};
		for(int i = 0; i < employee.length ; i++) {
			System.out.println(employee[i]);
		}
		System.out.println("------------------------------------------------------------");
		for(Sawon emp : employee) {
			System.out.println(emp);
		}
	
	}

}
