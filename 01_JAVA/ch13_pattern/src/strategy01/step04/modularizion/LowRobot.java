package strategy01.step04.modularizion;

import strategy01.step04.interfaces.FlyImpl;
import strategy01.step04.interfaces.FlyNo;
import strategy01.step04.interfaces.KnifeImpl;
import strategy01.step04.interfaces.KnifeNo;
import strategy01.step04.interfaces.MissileImpl;
import strategy01.step04.interfaces.MissileNo;

public class LowRobot extends Robot {

	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;

	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}

	@Override
	public void actionFly() {
		// 날 수 없습니다.
		fly.fly();
	}

	@Override
	public void actionMissile() {
		// 미사일을 쏠 수 없습니다.
		missile.missile();
	}

	@Override
	public void actionKnife() {
		// 검이 없습니다.
		knife.knife();
	}

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
