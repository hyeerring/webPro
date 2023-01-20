package singleton02;

public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass 생성자 실행 중");
		SingletonClass SingletonObject = SingletonClass.getInstance();
		System.out.println("싱글톤 객체의 i값: " + SingletonObject.getI());
		SingletonObject.setI(999);
		System.out.println("싱글톤 객체의 수정 후 i값: " + SingletonObject.getI());
	}
}
