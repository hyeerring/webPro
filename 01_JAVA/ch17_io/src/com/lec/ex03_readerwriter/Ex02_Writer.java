package com.lec.ex03_readerwriter;

import java.io.FileWriter;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/inTest.txt");
//			char[] msg = { "안", "녕", "하", "세", "요" };
			String msg = "안녕하세요, 자바\n안녕하세요, 세상";
			writer.write(msg);
			msg = "이번주 수요일 폭설예보입니다.";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

}
