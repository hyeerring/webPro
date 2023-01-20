package strategy01.step04.interfaces;

public class FlyYes implements FlyImpl {

	@Override
	public void fly() {
		// 날 수 있다.
		System.out.println("날 수 있습니다.");
	}

}
