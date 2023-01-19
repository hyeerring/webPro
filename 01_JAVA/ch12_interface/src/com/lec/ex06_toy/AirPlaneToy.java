package com.lec.ex06_toy;

public class AirPlaneToy implements IMissile, ILight {
	public AirPlaneToy() {
		System.out.println("비행기입니다.");
		canLight();
		canMissile();
		System.out.println("----------");
	}
	
	@Override
	public void canLight() {
		System.out.println("불빛을 쏠 수 있습니다.");
	}

	@Override
	public void canMissile() {
		System.out.println("미사일을 발사할 수 있습니다.");
	}

}
