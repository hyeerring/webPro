## [15] Exception 예외처리

자바에서 예외(exception) 란 사용자의 잘못된 조작이나 개발자의 코딩 실수로 인해 발생하는 프로그램 오류를 말한다. 예외가 발생되면 프로그램은 곧바로 종료된다는 점에서 에러와 동일하나, 예외는 예외 처리를 통해 프로그램을 종료하지 않고 정상 실행 상태가 유지되도록 할 수 있다.



### 예외처리 (try - catch)

```java
	try {
    예외가 발생할 가능성이 있는 명령문
  } catch (Exception type Exception 변수) {
    예외를 처리하는 명령문
  } finally {
    예외 발생 여부와 상관없이 마지막에 실행할 명령문
  }
```



### 예외 던지기 (throws)

`try - catch` 예외 처리 방법은 예외가 발생했을 때 자체적으로 catch문을 이용하여 해결했지만, 나를 호출한 곳에서 처리하도록 예외를 위로 던질 수 있는 방법이 있다.

```java
public class ThrowsEx {

	public ThrowsEx() throws Exception {
		actionC();
	}

	private void actionC() throws Exception {
		System.out.println("actionC 전반부");
		actionB();
		System.out.println("actionC 후반부");
	}

	private void actionB() throws Exception {
		System.out.println("actionB 전반부");
		actionA();
		System.out.println("actionB 후반부");
	}

	private void actionA() throws Exception {
		System.out.println("actionA 전반부");
		int[] arr = { 0, 1, 2 }; // 예외 발생
		System.out.println(arr[3]);
		System.out.println("actionA 후반부");
	}

}
```

```java
public class TestMain {

	public static void main(String[] args) {
		try {
			new ThrowsEx();
		} catch (Exception e) {
			System.out.println("예외 메세지: " + e.getMessage());
		}
	}
	/*actionC 전반부
		actionB 전반부
		actionA 전반부
		예외 메세지: 3 */
}
```



💡**일반적으로 많이 보게 되는 예외들**

-  **ArrayIndexOutOfBoundsException**  배열 사용 시 존재하지 않는 index값을 호출하면 발생

```java
	int[] iArr = {0,1,2,3};
		System.out.println(iArr[4]);
```

-  **NullPointerException**  존재하지 않는 객체를 가리킬 때 발생

```java
	String str = null;
	char c = str.charAt(0);
```

- **NumberFormatException**  숫자로 변경할 수 없는 문자열을 변경하려고 함.

```java
	public static void main(String[] args) {
		String str1 = "aa";
		String str2 = "10";
		int i = 10;
		int j = Integer.parseInt(str1)+i;
		j = Integer.parseInt(str2.trim())+i;
	}
```

- **DB관련 Exception**

- **ClassNotFoundException**  드라이브 이름을 찾지 못했을 때
- **SQLException**  db url, id, pw가 올바르지 않을 때