package com.lec.ex01_inputoutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* 1. 파일을 연다: stream 객체 생성
 * 2. 데이터를 읽는다: read(byte[]) byte 배열의 length만큼 읽는다.(read보다 속도가 빠름)
 * 3. 파일을 닫는다: close
 */
public class Ex02_InputStreamByteArray {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			// 1. 파일을 연다.
			is = new FileInputStream("txtFile/inTest.txt"); // 절대경로 또는 상대경로

			// 2. 데이터를 읽는다.(10byte씩 반복적으로 읽는다.)
			byte[] bs = new byte[10];
			// while의 끝일 때까지 읽는다.
			while (true) {
				int readByteCount = is.read(bs);
				if (readByteCount == -1) { // 파일의 끝이면 break;
					break;
				}
				for (int i = 0; i < bs.length; i++) {
					System.out.print((char) bs[i]);
				}
			}
			System.out.println("\nDONE");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}

}
