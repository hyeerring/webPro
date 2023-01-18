package com.lec.ex08_super;

public class TestMain {
	public static void main(String[] args) {

		Person papa = new Person();
		papa.setName("아빠곰");
		papa.setCharacter("뚱뚱해");
		papa.intro();
		papa.setName("아빠곰");

		Person mom = new Person("엄마곰", "날씬해");
		mom.intro();

		Person child1 = new Baby();
		child1.setName("첫째아기곰");
		child1.setCharacter("너무 귀여워");
		child1.intro();

		Baby child2 = new Baby("둘째아기곰", "너무 귀여워");
		child2.intro();
	}

}