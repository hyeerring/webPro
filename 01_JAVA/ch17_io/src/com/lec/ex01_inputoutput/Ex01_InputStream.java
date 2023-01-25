package com.lec.ex01_inputoutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* 1. 파일을 연다: stream 객체 생성
 * 2. 데이터를 읽는다: read 메소드 사용(1byte)
 * 3. 파일을 닫는다: close
 */
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;

		try {
			// 1. 파일을 연다.
			is = new FileInputStream("txtFile/inTest.txt");

			// 2. 데이터를 읽는다.
			while (true) {
				int i = is.read(); // 1 byte씩 읽는다.
				if (i == -1) { // 파일의 끝이면 break;
					break;
				}
				System.out.print((char) i);
			}
			System.out.println("\nDONE");
			
			
		} catch (FileNotFoundException e) {
			System.out.println("* 예외메세지: " + e.getMessage() + "*"); // 파일을 못찾음
		} catch (IOException e) {
			System.out.println("* 예외메세지: " + e.getMessage() + "*"); // 파일을 못읽음
		} finally {

			// 3. 파일을 닫는다.
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e2) {
				System.out.println("* 예외메세지: " + e2.getMessage() + "*"); // 파일을 못읽음
			}

		}
	}

}
