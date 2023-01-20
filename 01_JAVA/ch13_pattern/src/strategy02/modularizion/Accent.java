package strategy02.modularizion;

import strategy02.interfaces.EngineLow;
import strategy02.interfaces.FuelDiesel;
import strategy02.interfaces.Km20;

public class Accent extends Car {

	public Accent() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}
	@Override
	public void shape() {
		System.out.println("어센트 차량은 문, 시트, 핸들로 이루어져 있습니다.");
	}

}
