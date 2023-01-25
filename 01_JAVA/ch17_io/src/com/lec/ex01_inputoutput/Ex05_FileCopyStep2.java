package com.lec.ex01_inputoutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// /Users/hyerin/Documents/webpro/note/bts.mp4 (8,075,033 byte)
// --> /Users/hyerin/Documents/webpro/note/bts_copy.mp4

public class Ex05_FileCopyStep2 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); // 1970.01.01 부터 시작지점까지의 밀리세컨
		InputStream is = null;
		OutputStream os = null;

		// * 1. 스트림 객체 생성
		try {
			is = new FileInputStream("/Users/hyerin/Documents/webpro/note/bts.mp4");
			os = new FileOutputStream("/Users/hyerin/Documents/webpro/note/bts_copy.mp4");
			byte[] bs = new byte[1024]; // 1Kbyte
			int cnt = 0;
			while (true) {
				cnt++;
				// * 2. read(bs에 읽음) & write
				int count = is.read(bs);
				if (count == -1)
					break;
				os.write(bs, 0, count); // bs배열을 0 index부터 count byte만큼 write
			}
			System.out.println("복사 성공");
		} catch (FileNotFoundException e) {
			// 파일 또는 폴더를 못 찾는 예외
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// 파일을 읽지 못하는 예외
			e.printStackTrace();
		} finally {
			try {
				if (os != null)
					os.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
		long end = System.currentTimeMillis(); // 1970.1.1 ~ 끝나는 시점까지의 밀리세컨
		System.out.println(end - start);
	}
}