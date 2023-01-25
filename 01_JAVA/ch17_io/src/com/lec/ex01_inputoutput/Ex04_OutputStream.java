package com.lec.ex01_inputoutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* 1. 파일을 쓴다: stream 객체 생성
 * 2. 데이터를 읽는다: write 메소드 사용(1byte)
 * 3. 파일을 닫는다: close
 */
public class Ex04_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null; // 객체생성

		try {
			// 해당 폴더가 없을 시 예외 발생
			// 1. 파일을 연다.
			os = new FileOutputStream("txtFile/outTest.txt"); /* (1) */
			String msg = "Hello, Java\n안녕, 자바";
			byte[] bs = msg.getBytes(); // String을 byte 배열로 바꾸는 함수
			
			// 2. 데이터를 쓴다.
			
//			for문을 이용한 출력
//			for (byte b : bs) {
//				os.write(b);
//			}
			
			os.write(bs); /* (2) */
//			System.out.println("파일 출력 성공");
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException ignore) {
				System.out.println(ignore.getMessage());
			}
		}
	}

}
