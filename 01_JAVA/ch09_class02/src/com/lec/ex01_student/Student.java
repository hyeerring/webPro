package com.lec.ex01_student;

// 데이터: string name, int kor, int eng, int mat, int tot, double avg
// 메소드: infoString(), infoPrint()
// Student st = new Student();
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;

	public Student() {
	}

	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor + eng + mat;
		this.avg = tot / 3.0;
	}
	// student s = new Student("정우성", 100, 100, 100);
	// sysout(s.infoString()) => \t정우성\t100\t100\t100\t300\t100.00

// sysout(st.infoString()); 처럼 쓰기 위해 만드는 메소드
	public String infoString() {
		return String.format("\t%s\t%d\t%d\t%d\t%d\t%.1f\n", name, kor, eng, mat, tot, avg);
	}

// 입력과 함께 바로 출력
	public void infoPrint() {
		System.out.printf("\t%s\t%d\t%d\t%d\t%d\t%.1f\n", name, kor, eng, mat, tot, avg);
	}

	// setters
	public void setName(String name) {
		this.name = name;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public String getName() {
		return name;
	}

	// getters
	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMat() {
		return mat;
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}

}
