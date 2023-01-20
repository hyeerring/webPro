package strategy01.step05.modularizion;

import strategy01.step04.interfaces.FlyNo;
import strategy01.step04.interfaces.KnifeWood;
import strategy01.step04.interfaces.MissileYes;

public class StandardRobot extends Robot {

	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
	}

}
