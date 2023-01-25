package com.lec.ex03_readerwriter;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

// 파일이름과 파일 출력 message를 콘솔에서 입력
public class Ex03 {
	public static void main(String[] args) {
		Writer writer = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("저장된 파일 이름을 입력하세요: ");
		String fileName = scanner.next(); // abc --> txtFile/abc.txt
		scanner.nextLine(); // cleaner
		try {
			writer = new FileWriter("txtFile/" + fileName + ".txt");
			while (true) {
				System.out.println("출력할 메세지(종료 x):");
				String msg = scanner.nextLine();
				if (msg.equalsIgnoreCase("x")) {
					break;
				}
				writer.write(msg + "\n");
			}
			System.out.println(fileName + "파일 저장 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	} // main
} // class
