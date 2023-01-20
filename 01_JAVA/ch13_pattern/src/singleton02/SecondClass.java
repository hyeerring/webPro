package singleton02;

public class SecondClass {
	public SecondClass() {
		System.out.println("SecondClass 생성자 실행 중");
		SingletonClass SingletonObject = SingletonClass.getInstance();
		System.out.println("싱글톤 객체의 i값: " + SingletonObject.getI());
	}
	
}
