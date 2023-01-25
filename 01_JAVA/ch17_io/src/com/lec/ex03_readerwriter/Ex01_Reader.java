package com.lec.ex03_readerwriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); // * 1단계
			while (true) { // * 2단계
				int i = reader.read(); // 2byte 씩 읽는다.
				if (i == -1) {
					break;
				}
					System.out.println((char)i + "(" + ")");
			}
		} catch (Exception e) {
		} finally {
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (IOException e) {
				System.out.println(e.getMessage());
				}
			}
		}

	}