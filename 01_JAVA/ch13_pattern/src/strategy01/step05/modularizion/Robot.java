package strategy01.step05.modularizion;

import strategy01.step04.interfaces.FlyImpl;
import strategy01.step04.interfaces.KnifeImpl;
import strategy01.step04.interfaces.MissileImpl;

public class Robot {
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;

	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}

	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}

	public void shape() {
		String className = getClass().getName(); // 클래스 이름("strategy01.step02.SuperRobot")
		int idx = className.lastIndexOf("."); // idx = 15
		String name = className.substring(idx + 1); // 16번째 부터
		System.out.println(name + "는 팔, 다리, 몸통, 머리가 있습니다.");
	}

	public void actionFly() {
		fly.fly();
	}

	public void actionMissile() {
		missile.missile();
	}

	public void actionKnife() {
		knife.knife();
	}

	// setter
	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}
}
