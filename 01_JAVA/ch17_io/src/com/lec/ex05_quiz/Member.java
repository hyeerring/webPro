package com.lec.ex05_quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {

	private String name;
	private String tel;
	private Date birth;
	private String add;

	public Member() {
	}

	public Member(String name, String tel, Date birth, String add) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.add = add;
	}

	@Override
	public String toString() {
		String result;
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		result = name + "\t" + tel + "\t" + sdf.format(birth) + "\t" + add + "\n";
		return result;
	}
	
	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public Date getBirth() {
		return birth;
	}

	public String getAdd() {
		return add;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setAdd(String add) {
		this.add = add;
	}
	
}
