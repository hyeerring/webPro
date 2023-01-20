package strategy01.step04.modularizion;

import strategy01.step04.interfaces.FlyImpl;
import strategy01.step04.interfaces.FlyYes;
import strategy01.step04.interfaces.KnifeImpl;
import strategy01.step04.interfaces.KnifeLazer;
import strategy01.step04.interfaces.MissileImpl;
import strategy01.step04.interfaces.MissileYes;

public class SuperRobot extends Robot {
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;

	public SuperRobot() {
		setFly(new FlyYes()); // fly = new FlyYes();
		setMissile(new MissileYes()); // missile = new MissileYes();
		setKnife(new KnifeLazer()); // knife = new KnifeLazer();
	}

	@Override
	public void actionFly() {
		// 날 수 있습니다.
		fly.fly();
	}

	@Override
	public void actionMissile() {
		// 미사일을 쏠 수 있습니다.
		missile.missile();
	}

	@Override
	public void actionKnife() {
		// 레이저검이 있습니다.
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
