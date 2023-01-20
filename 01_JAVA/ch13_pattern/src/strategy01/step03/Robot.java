package strategy01.step03;

public abstract class Robot {
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}
	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}
	public void shape() {
		String className = getClass().getName(); // 클래스 이름("strategy01.step02.SuperRobot")
		int idx = className.lastIndexOf("."); // idx = 15
		String name = className.substring(idx+1); // 16번째 부터
		System.out.println(name + "는 팔, 다리, 몸통, 머리가 있습니다.");
	}
	// 추상메소드
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
	
}
