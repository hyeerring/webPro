package strategy02.interfaces;

public class FuelDiesel implements FuelImpl {

	@Override
	public void fuel() {
		System.out.println("경유");
	}

}
