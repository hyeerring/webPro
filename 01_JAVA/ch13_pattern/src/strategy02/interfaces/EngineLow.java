package strategy02.interfaces;

public class EngineLow implements EngineImpl {

	@Override
	public void engine() {
		System.out.println("엔진: 저급엔진");
	}

}
