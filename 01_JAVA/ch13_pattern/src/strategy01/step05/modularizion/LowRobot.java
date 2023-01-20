package strategy01.step05.modularizion;

import strategy01.step04.interfaces.FlyNo;
import strategy01.step04.interfaces.KnifeNo;
import strategy01.step04.interfaces.MissileNo;

public class LowRobot extends Robot {

	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}

}
