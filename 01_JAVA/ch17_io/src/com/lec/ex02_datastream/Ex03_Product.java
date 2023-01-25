package com.lec.ex02_datastream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

// x를 입력할 때 까지 재고등록(제품명, 가격, 재고수량) : file 출력
// x입력 시 등록된 모든 재고 목록을 출력
public class Ex03_Product {
	public static void main(String[] args) {
		OutputStream fos = null;
		DataOutputStream dos = null;
		Scanner scanner = new Scanner(System.in);
		try {
			fos = new FileOutputStream("src/com/lec/ex02_datastream/product.dat", true);
			dos = new DataOutputStream(fos);
			while (true) {
				System.out.println("재고 추가를 하시겠습니까?(y/n): ");
				if (scanner.next().equalsIgnoreCase("n")) {
					break;
				}
				System.out.print("제품명: ");
				dos.writeUTF(scanner.next());
				System.out.print("가격: ");
				dos.writeInt(scanner.nextInt());
				System.out.print("재고: ");
				int stock = scanner.nextInt();
				dos.writeInt(stock);
			}
			System.out.println("재고 등록 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} // close
			ArrayList<Product> products = new ArrayList<Product>();
			InputStream fis = null;
			DataInputStream dis = null;

			
			try {
				fis = new FileInputStream("src/com/lec/ex02_datastream/product.dat");
				dis = new DataInputStream(fis);
				while (true) {
					Product product = new Product();
					product.setName(dis.readUTF());
					product.setPrice(dis.readInt());
					product.setStock(dis.readInt());
					products.add(product);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (dis != null)
						dis.close();
					if (fis != null)
						fis.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			if (products.isEmpty()) {
				System.out.println("등록된 재고가 없습니다.");
			} else {
				System.out.println("제품명\t가격\t재고");
				for (Product product : products) {
					System.out.println(product);
				}
				System.out.println("이상 " + products.size() + "가지 재고 물품 입력됨");
			}

		}
	}
}
