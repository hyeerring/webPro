package com.lec.ex03_excetions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String tel;
	private Date birthday;

	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public Friend(String name, String tel, Date birthday) {
		super();
		this.name = name;
		this.tel = tel;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		if (birthday != null) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "[이름] " + name + "\t[전화번호] " + tel + "\t[생일] " + sdf.format(birthday);
		}
		return "[이름] " + name + "\t[전화번호] " + tel + "\t[생일] " + "모름";
	}

}
