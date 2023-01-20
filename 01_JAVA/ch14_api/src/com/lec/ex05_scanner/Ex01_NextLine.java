package com.lex.ex05_scanner;

import java.util.Scanner;

public class Ex01_NextLine {
	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	System.out.print("나이를 입력하세요: ");
	int age = scanner.nextInt();
	System.out.println("입력한 나이는 " + age + "살 입니다.");
	
	System.out.print("이름을 입력하세요: ");
	String name = scanner.next();
	System.out.println("입력한 이름은 " + name + "입니다.");

	System.out.print("주소를 입력하세요: ");
	// 버퍼에 남아있는 \n 제거 필요
	scanner.nextLine();
	String address = scanner.nextLine(); // "\n"의 값을 return하고 "\n" 뒤를 지운다
	System.out.println("입력한 주소는 " + address + "입니다.");
	System.out.println("끝");
	}
}
