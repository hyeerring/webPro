package strategy01.step05.modularizion;

import strategy01.step04.interfaces.FlyHigh;
import strategy01.step04.interfaces.KnifeToy;

public class TestMain {
	public static void main(String[] args) {
		Robot[] robots = { new SuperRobot(), new StandardRobot(), new LowRobot() };

		for (Robot robot : robots) {
			robot.shape();
			robot.actionRun();
			robot.actionWalk();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
		}
		System.out.println("SuperRobot의 나는 부품을 아주 높이 나는 기능으로 업그레이드");
		robots[0].setFly(new FlyHigh());
		robots[0].shape();
		robots[0].actionFly();
		System.out.println("LowRobot의 knife를 장난감 검으로 업그레이드");
		robots[2].setKnife(new KnifeToy());
		robots[2].actionKnife();
	}

}
