package strategy01.step05.modularizion;

import strategy01.step04.interfaces.FlyYes;
import strategy01.step04.interfaces.KnifeLazer;
import strategy01.step04.interfaces.MissileYes;

public class SuperRobot extends Robot {

	public SuperRobot() {
		setFly(new FlyYes()); // fly = new FlyYes();
		setMissile(new MissileYes()); // missile = new MissileYes();
		setKnife(new KnifeLazer()); // knife = new KnifeLazer();
	}

}
