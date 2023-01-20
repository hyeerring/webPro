package strategy01.step04.interfaces;

public class FlyNo implements FlyImpl {

	@Override
	public void fly() {
		// 날 수 없다.
		System.out.println("날 수 없습니다.");
	}

}
