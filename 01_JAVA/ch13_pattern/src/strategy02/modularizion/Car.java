package strategy02.modularizion;

import strategy02.interfaces.*;

public abstract class Car {
	private EngineImpl engine;
	private KmImpl km;
	private FuelImpl fuel;

	public void drive() {
		System.out.println("드라이브 할 수 있습니다.");
	}

	public abstract void shape();

	public void isEngine() {
		engine.engine();
	}

	public void isKmPerLitter() {
		km.km();
	}

	public void isFuel() {
		fuel.fuel();
	}

	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}

	public void setKm(KmImpl km) {
		this.km = km;
	}

	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;
	}

}
