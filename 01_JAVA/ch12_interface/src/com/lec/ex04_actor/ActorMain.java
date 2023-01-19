package com.lec.ex04_actor;

public class ActorMain {
	public static void main(String[] args) {

		Actor gong = new Actor("공유");
		gong.makePizza();
		gong.makeSpaghetti();
		gong.outFire();
		gong.saveMan();
		gong.canCatchCriminal();
		gong.canSearch();
		
		Chef chefGong = gong;
		gong.makePizza();
		gong.makeSpaghetti();
		gong.outFire();
		gong.saveMan();
		gong.canCatchCriminal();
		gong.canSearch();
		
		FireFighter fireGong = gong;
		gong.makePizza();
		gong.makeSpaghetti();
		gong.outFire();
		gong.saveMan();
		gong.canCatchCriminal();
		gong.canSearch();
		
		PoliceMan policeGong = gong;
		gong.makePizza();
		gong.makeSpaghetti();
		gong.outFire();
		gong.saveMan();
		gong.canCatchCriminal();
		gong.canSearch();
	}

}
