package com.lex.ex02_datequiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon2 {

	private String num; // 사번
	private String name; // 이름
	private Dept dep; // 부서
	private Date date; // 입사일

	public Sawon2(String num, String name, Dept dep) {
		this.num = num;
		this.name = name;
		this.dep = dep;
		date = new Date();
	}

	public Sawon2(String num, String name, Dept dep, int year, int month, int day) {
		this.num = num;
		this.name = name;
		this.dep = dep;
		date = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		String grStr = sdf.format(date.getTime());
		return "[사번] " + num + "  [이름] " + name + "  [부서] " + getDep() + "  [입사일] " + grStr;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dept getDep() {
		return dep;
	}

	public void setDep(Dept dep) {
		this.dep = dep;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
