package com.lec.ex07_robot;

// RobotOrder order = new RobotOrder();
// orger.action(singRobot);
public class RobotOrder {

	public void acction(Robot robot) {
		if (robot instanceof DanceRobot) {
			// ((DanceRobot)robot).dance();
			DanceRobot tempRobot = (DanceRobot) robot;
			tempRobot.Dance();
		} else if (robot instanceof DrawRobot) {
			DrawRobot tempDrawRobot = (DrawRobot) robot;
			tempDrawRobot.Draw();
		} else if (robot instanceof SingRobot) {
			SingRobot tempSingRobot = (SingRobot) robot;
			tempSingRobot.Sing();
		} else {
			System.out.println("확장된 로봇 구현이 필요합니다.");
		}

	}

}
