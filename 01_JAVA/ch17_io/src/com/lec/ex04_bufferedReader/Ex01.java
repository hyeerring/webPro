package com.lec.ex04_bufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01 {

	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;

		try {
			reader = new FileReader("txtFile/inTest.txt"); // * 1. stream 생성
			br = new BufferedReader(reader); // 보조스트림은 기본스트림을 통하는 것이 안전
			while (true) {
				String linedata = br.readLine(); // * 2. 한 줄씩 읽는다.
				if (linedata == null) {
					break;
				}
				System.out.println(linedata);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}