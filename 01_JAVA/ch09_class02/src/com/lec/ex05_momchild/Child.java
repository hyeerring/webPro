package com.lec.ex05_momchild;

// child child1 = new child("첫째 밤이")
public class Child {
	private String name;
	static MomPouch MomPouch;
	public Child(String name) {
		this.name = name;
		MomPouch = new MomPouch();
	}
	public void takeMoney(int money) {
		if (MomPouch.money >= money) {
			MomPouch.money -= money;
			System.out.println(name +"가 " + money + "원 가져가서 엄마 지갑엔 " + MomPouch.money + "원이 남았다.");
		} else {
			System.out.println(name +"가 돈 못 받음. 현재 엄마 지갑엔 " + MomPouch.money + "원이 남았다.");
			
		}
	}
	
}
