package com.lec.ex02_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// OutputStream을 보조(조금 발전된 stream)
public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null; // 기본 스트림
		DataOutputStream dos = null; // 보조 스트림
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat");
			dos = new DataOutputStream(fos);
			dos.writeUTF("김길동"); // 스트링 저장
			dos.writeInt(2);
			dos.writeDouble(95.5);

			dos.writeUTF("이길동");
			dos.writeInt(6);
			dos.writeDouble(98.5);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null) {
					dos.close();	
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
