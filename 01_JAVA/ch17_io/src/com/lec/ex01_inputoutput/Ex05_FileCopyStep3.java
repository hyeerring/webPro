package com.lec.ex01_inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// JSP나 Spring에서 파일첨부 게시판 작성 시 copy할 로직 
// /Users/hyerin/Documents/webpro/note/bts.mp4 (8,075,033 byte)
// --> /Users/hyerin/Documents/webpro/note/bts_copy.mp4

public class Ex05_FileCopyStep3 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;

		try {
			File /* original */ file = new File("/Users/hyerin/Documents/webpro/note/bts.mp4");
			is = new FileInputStream(file);
			os = new FileOutputStream("/Users/hyerin/Documents/webpro/note/bts_copy.mp4");
			byte[] bs = new byte[(int) file.length()];
			while (true) {
				int count = is.read(bs);
				if (count == -1)
					break;
			}
			System.out.println("복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
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
		}
	}
}