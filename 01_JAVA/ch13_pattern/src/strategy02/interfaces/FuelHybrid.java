package strategy02.interfaces;

public class FuelHybrid implements FuelImpl {

	@Override
	public void fuel() {
		System.out.println("전기 하이브리드로 움직입니다.");
	}

}
