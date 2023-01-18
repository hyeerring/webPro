package com.lec.quiz;

// 번호, 이름, 국, 영, 수, 총합, 평균 
// 객체생성: new Student(정우성, 90, 80, 100) -> 번호, 총점, 평균도 같이 초기화
public class Student {

	private int no;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int avg;

	public static int count = 0;

	public Student(String name, int kor, int eng, int mat) {
		no = ++count;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor + eng + mat;
		this.avg = tot / 3;
	}

	public String infoString() {
		return String.format("\t%d\t%s\t%d\t%d\t%d\t%d\t%d\n", no, name, kor, eng, mat, tot, avg);
	}

	public static void line(char c, int j) {
		for (int i = 1; i < j; i++) {
			System.out.print(c);
		}
		System.out.println();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}

	public static int getCount() {
		return count;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}
