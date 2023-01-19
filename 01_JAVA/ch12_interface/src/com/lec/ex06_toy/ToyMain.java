package com.lec.ex06_toy;

public class ToyMain {

	public static void main(String[] args) {
		/* PoohToy pooh = new PoohToy();
		MazingerToy mazinger = new MazingerToy();
		AirPlaneToy airPlanToy = new AirPlaneToy(); */

		IToy pooh = new PoohToy();
		IToy mazinger = new MazingerToy();
		IToy airPlane = new AirPlaneToy();
		IToy[] toys = { pooh, mazinger, airPlane };
		for (IToy iToy : toys) {
			System.out.println(iToy.getClass().getName());
		}

	}

}
