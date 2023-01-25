package com.lec.ex05_printwriter;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class Ex01 {
	public static void main(String[] args) {
		OutputStream os = null; // 기본 stream
		Writer writer = null; // 기본 stream
		PrintWriter printWriter = null;
		
		try {
			// * 1. OutputStream의 보조 stream 역할
//			os = new FileOutputStream("txtFile/outTest.txt", true);
//			printWriter = new PrintWriter(os + "\t");
			
			// * 2. PrintWriter : Writer의 보조 stream
//			writer = new FileWriter("txtFile/outTest.txt", true);
//			printWriter = new PrintWriter(writer);
			
			// * 3. PrintWriter을 기본 stream처럼 사용
			printWriter = new PrintWriter("txtFile/outTest.txt"); // append 불가
			
			System.out.println("안녕하세요.");
			printWriter.println("안녕하세요.");
			System.out.println("자바입니다.");
			printWriter.println("자바입니다.");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (printWriter != null) {
					printWriter.close();
				}
				if (os != null) {
				os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // finally
	} // main

} // class
