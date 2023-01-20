package strategy01.step04.interfaces;

public class FlyHigh implements FlyImpl {

	@Override
	public void fly() {
		// 매우 높이 날 수 있습니다.
		System.out.println("아주 높이 날 수 있습니다.");
	}

}
