package com.lec.ex02;

// ctrl + shift + o: 불필요한 import 제거
import com.lec.ex02_human.*;
import com.lec.ex02_human.kid.Kid;

public class HumanMain {
	public static void main(String[] args) {
		Woman woman1 = new Woman();
		Woman woman2 = new Woman();
		// ------------ ------------
		// 레퍼런스 변수(객체변수) 선언 객체생성(인스턴트 생성)

//		System.out.println("woman1과 woman2가 같은가: " + (woman1 == woman2));
		System.out.println("woman1과 woman2가 같은가: " + woman1.equals(woman2));
		Man man = new Man();
		Kid kid = new Kid("김첫째"); // 하위 패키지는 다른 패키지로 본다.
//		Kid kid2 = new Kid(); 개발자가 생성자 함수를 만들면 디폴트 생성자 함수는 자동 생성 안 함
		Man hong = new Man("홍길동");
		Man kim = new Man("김길동", 31, 180, 68);
		Man kim2 = kim;
		
		kim2.setHeight(186); kim2.setWeight(200);
		System.out.println("kim과 kim2가 같은 객체인가 : " + kim.equals(kim2));
		double bmi = kim.calculateBMI();
		System.out.println(kim.getName() + "의 BMI지수는 " + bmi);
	}
}
