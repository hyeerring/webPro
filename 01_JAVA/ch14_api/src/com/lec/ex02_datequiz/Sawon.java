package com.lex.ex02_datequiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {

	// COMNUTER_TEAM으로 입력할 경우 다른 팀으로 입력되는 것을 막기 위한 가이드라인
	public static final String COMPUTER = "전산팀";
	public static final String PLANNING = "미래전략팀";
	public static final String DESIGN = "홍보팀";
	public static final String ACCOUNTING = "회계팀";
	public static final String HUMANRESOURCES = "인사팀";

	private String num; // 사번
	private String name; // 이름
	private String dep; // 부서
	private Date date; // 입사일

	public Sawon(String num, String name, String dep) {
		this.num = num;
		this.name = name;
		this.dep = dep;
		date = new Date();
	}

	public Sawon(String num, String name, String dep, int year, int month, int day) {
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

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
