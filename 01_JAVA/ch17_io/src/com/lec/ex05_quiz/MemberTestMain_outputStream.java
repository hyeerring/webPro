package com.lec.ex05_quiz;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now);
		String birthStr;
		int year = 0, month = 0, day = 0;
		String answer;

		do {
			System.out.print("회원가입을 하시겠습니까(y/n): ");
			answer = scanner.next();
			if (answer.trim().equalsIgnoreCase("n")) {
				scanner.close();
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			Member member = new Member();
			System.out.print("이름을 입력하세요: ");
			member.setName(scanner.next());
			System.out.print("전화번호를 입력하세요: ");
			member.setTel(scanner.next());
			System.out.print("생일을 입력하세요: ");
			birthStr = scanner.next();
			StringTokenizer token = new StringTokenizer(birthStr, "-");
			if (token.countTokens() == 3) {
				year = Integer.parseInt(token.nextToken());
				month = Integer.parseInt(token.nextToken());
				day = Integer.parseInt(token.nextToken());
			} else {
				System.out.println("잘못된 생일 형식입니다.");
				continue;
			}
			member.setBirth(new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis()));
			System.out.print("주소를 입력하세요: ");
			scanner.nextLine(); // cleaner
			member.setAdd(scanner.nextLine());

			members.add(member);
			System.out.println(member.getName() + "님 환영합니다.\n");

		} while (true);
		scanner.close();
		
		// "n"을 입력하면 ArrayList 정보를 파일과 콘솔에 출력
		OutputStream os = null;

		try {
			os = new FileOutputStream("src/com/lec/ex05_quiz/member.txt"/* , true */);
			for (Member member : members) {
				System.out.println(member);
				os.write(member.toString().getBytes());
			}
			String msg = String.format("---- 합계: %d명 가입 ----", members.size());
			System.out.println(msg);
			os.write(msg.getBytes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} // finally

	} // main

} // class
