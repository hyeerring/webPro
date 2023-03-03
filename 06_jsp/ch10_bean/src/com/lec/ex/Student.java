package com.lec.ex;

public class Student {
	private String id;
	private String name;
	private int grade;
	private char clas;
	private int score;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String id, String name, int grade, char clas, int score) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.clas = clas;
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public char getClas() {
		return clas;
	}

	public void setClas(char clas) {
		this.clas = clas;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
