## [14] API

자바 표준 라이브러리는 프로그램을 효율적으로 개발할 수 있도록 자주 사용하는 함수나 데이터들을 미리 만들어 놓은 집합체이다. 이 라이브러리는 JDK안에 포함되어 있어 자바 가상머신이 자바 프로그램을 실행할 때 이 라이브러리의 클래스와 인터페이스들을 자동으로 읽어들이기 때문에  필요할 때 언제든지 호출하여 사용할 수 있다.



**Java의 대표적인 표준 라이브러리**

- **java.lang** 자바프로그램의 기본적인 기능을 제공. 명시적으로 지정하지 않아도 모든 자바 프로그램에 포함되는 패키지(java.lang.String나 java.lang.Exception은 모두 java.lang.을 생략 가능)
- **java.util** 유용한 유틸리티 클래스를 제공
- **java.io** 입출력 기능을 제공하는 패키지
- **java.awt** 그래픽 유저인터페이스(GUI)를 구축하기 위한 다양한 컴포넌트를 제공하는 패키지
- **java.awt.event** awt컴포넌트들의 이벤트를 제어하는 패키지



### String

문자열에 관련된 대표적인 클래스 String은 객체자료형이다. 하지만 뒤에 생성자(new)를 사용하지 않고 기초데이터를 만들때처럼 초기화한다.



**String의 주요 기능들**

```java
public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = "    ja  va    ";

		// concat(): + 한 값을 return
		System.out.println(str1.concat(str2)); // abcXabcabcXabc

		// substring(): 호출된 숫자 위치 글씨부터 끝까지 추출
		System.out.println(str1.substring(3)); // Xabc

		// substring( , ): 호출된 숫자 위치 글씨부터 호출된 숫자 앞까지
		System.out.println(str1.substring(3, 5)); // Xa

		// length(): 문자열 길이
		System.out.println(str1.length()); // 7

		// toUpperCase(): 대문자로 변환
		System.out.println(str1.toUpperCase()); // ABCXABC

		// toLowerCase(): 소문자로 변환
		System.out.println(str1.toLowerCase()); // abcxabc

		// charAt(): 호출된 위치의 문자
		System.out.println(str1.charAt(3)); // X

		// indexOf(): 첫번째 해당 문자의 인덱스
		System.out.println(str1.indexOf('b')); // 1

		// lastIndexOf(): 마지막 문자 인덱스
		System.out.println(str1.lastIndexOf('b')); // 5

		// indexOf( , ): @번째 나오는 문자의 인덱스
		String str4 = "abcXabcXabcXabcXabcXabc";
		System.out.println(str4.indexOf('b', 6)); // 5
  
		// indexOf(" "): 처음 나오는 해당 문자열의 인덱스
		System.out.println(str4.indexOf("cXa")); // 2

  	// indexOf( , ): @번째 나오는 문자의 인덱스
		System.out.println(str4.indexOf("cXa", 9)); // 10

		// indexOf(): 없을 경우 -1
		System.out.println(str4.indexOf('z')); // -1

		// equals(): string이 같은지 비교
		System.out.println(str1.equals(str2)); // true

		// equalsIgnoreCase(): 대소문자 구별없이 비교
		System.out.println(str1.equalsIgnoreCase("abcxabc")); // true

		// trim(): 앞 뒤 스페이스 제거
		System.out.println(str3.trim()); // ja va

		// replace( , ): 해당 문자, 문자열을 변경
		System.out.println(str4.replace("abc", "change")); // changeXchangeXchange ...
}
```



**String의 문제점**

String은 많이 쓰이고 좋은 메소드를 많이 가지고 있지만 치명적인 단점이 있다. 바로 메모리를 과소비하는 것이다. String 객체의 경우 처음 초기화 된 데이터에 변화가 생기면 기존 것을 재활용하지 않고 기존의 것은 버리고 새로운 메모리를 이용한다.

그렇기 때문에 문자열 조작을 많이 하는 프로그램에서 이런 메소드를 많이 사용하면 String 객체가 너무 많이 생기기 때문에 효율적이지 않다. 많은 객체를 만들게 되면 메모리도 많이 쓰게되고 프로그램의 성능도 떨어지기 때문이다.



### StringBuffer와 StringBuilder

문자열 변수의 잦은 내용 변경이 불가피 할 시에는 문자열 조작에 적합하게 만들어진 다른 클래스를 사용하는 것이 좋습니다. 문자열 조작에 적합하게 만들어진 클래스로는 StringBuffer클래스와 StringBuilder클래스가 있습니다.

이 클래스들은 모두 객체 내부에 있는 버퍼(buffer, 데이터를 임시로 저장하는 메모리)에 문자열의 내용을 저장해 두고 그 안에서 추가, 수정, 삭제 작업을 하기때문에 이 클래스들은 이용하면 새로운 객체를 만들지 않고도 문자열 조작을 할 수 있습니다.



**StringBuilder 주요 기능(메소드)**

- **append(String str)**  문자열 str 추가
- **insert(int index, String str)**  특정 index에 문자열 str 추가
- **delete(int start, int end)**  index위치 start부터 end앞 까지 삭제
- **deleteCharAt(int index)**  index위치의 특정 문자 하나 삭제
- **int capacity( )**  문자열 크기 반환
- **ensureCapacity(int size)**  버퍼의 크기를 size만큼 늘리는 메소드
- **trimToSize( )**  과도한 버퍼 크기를 적당하게 줄이는 메소드



----

### Calender API

- **Calender 클래스**

  날짜와 시간을 표현할 때 많이 쓰이는 추상클래스. 추상클래스이기 때문에 생성자는 호출하지 못하고 `getInstance()` 메소드로 호출해야 한다.

- **GregorianCalender 클래스**

  위와 마찬가지로 날짜를 표현할 때 많이 쓰이는 일반클래스. 객체를 생성할 수 있기 때문에 생성자의 매개변수를 통해 특정날짜를 지정할 수 있다.

- **SimpleDateFormat 클래스**

  Java.text 패키지에 존재하는 클래스로 생성자 또는 메소드의 지정된 속성을 통해서 날짜와 시간 출력 서식을 구현하는 클래스이다.

  | 패턴 | 설명                      |      |                           |
  | ---- | ------------------------- | ---- | ------------------------- |
  | yyyy | 년도 4자리                | yy   | 년도 2자리                |
  | MM   | 01월                      | M    | 1월                       |
  | dd   | 01일                      | d    | 1일                       |
  | E    | 요일                      | a    | 오전/오후                 |
  | H    | 24시간                    | h    | 12시간                    |
  | m    | 분                        | s    | 초                        |
  | w    | 일년 안에서 몇번째 주인지 | W    | 한달 안에서 몇번째 주인지 |
  | D    | 일년 안에서 몇번째 일인지 |      |                           |
  |      |                           |      |                           |



----

### Object

- **toString()**

  Object 클래스의 toString() 메소드는 객체의 문자 정보를 리턴한다. 기본적으로 `클래스명@16진수해시코드`로 구성된 문자 정보를 리턴하지만 오버라이팅을 이용하여 객체의 인스턴스 값을 반환할 수 있다.

- **equals(Object obj)**

  두 객체의 값을 비교하는 메소드. 기본적으로 Object 클래스에서는 객체의 주소를 비교하지만 오버라이딩을 이용해 객체 변수값을 비교할 수 있다.

- **hashCode()**

  객체의 메모리 번지를 이용하여 해시코드를 만들어 리턴한다. 따라서 객체마다 다른 값을 가지고 있다.



----

### Math

```java
package com.lex.ex03_math;

public class Ex01_Math {

	public static void main(String[] args) {
		int a = 2;
		int b = 10;
		// pow(a, b): a의 b승
		System.out.println("a의 b승: " + (int) Math.pow(a, b));
		// abs(a): a의 절대 값
		System.out.println("-9의 절대 값: " + Math.abs(-9.9));
		// a와 b 중 최소값
		System.out.println("a와 b중 최소 값 " + Math.min(a, b));
		// a와 b 중 최대값
		System.out.println("a와 b중 최대 값 " + Math.max(a, b));
		// Math의 final 변수
		System.out.println("PI = " + Math.PI);
	}

}
```

```java
package com.lex.ex03_math;

/* Math.ceil(올릴 실수):double값 return
 ex) Math.ceil(9.1) // 10.0
 
 Math.round(반올림 할 실수): long값 return
 ex) Math.round(9.16) // 9
 
 Math.floor(버릴 실수): double값 return
 ex) Math.floor(9.99) // 9.0
 */
public class Ex02_round {
	public static void main(String[] args) {
		System.out.println("소수점에서 올림, 반올림, 버림");
		System.out.println("9.15를 올림: " + Math.ceil(9.15)); // 10.0
		System.out.println("9.15를 반올림: " + Math.round(9.15)); // 9
		System.out.println("9.15를 버림: " + Math.floor(9.15)); // 9.0

		System.out.println("소수점 한자리에서 반올림, 올림, 버림");
		System.out.println("9.15를 올림: " + Math.ceil(9.15 * 10) / 10); // 9.2
		System.out.println("9.15를 반올림: " + Math.round(9.15 * 10) / 10.0); // 9.2
		System.out.println("9.15를 버림: " + Math.floor(9.15 * 10) / 10); // 9.1

		System.out.println("일의 자리에서 반올림, 올림, 버림");
		System.out.println("85를 올림: " + Math.ceil(85 / 10.0) * 10); // 90.0
		System.out.println("85를 반올림: " + Math.round(85 / 10.0) * 10); // 90
		System.out.println("85를 버림: " + Math.floor(85 / 10.0) * 10); // 80.0
	}
}

```



### Random

### Scanner

키보드에서 타이핑하는 문자열 또는 입출력 프로그래밍에서 값을 읽어올 때 사용

### Wrapper

기초데이터를 객체데이터로 변화시키는 클래스

| 기초데이터 | 객체데이터 |
| ---------- | ---------- |
| byte       | Byte       |
| short      | Short      |
| int        | Integer    |
| long       | Long       |
| float      | Float      |
| double     | Double     |
| boolean    | Boolean    |
| char       | Character  |



### Timer

자바에서의 타이머는 두가지이다. 일정한 시간마다 작동되는 타이머 프로그램과 일정한 시간이 되면 한번 실행하는 타이머 프로그램이다.

- **Timer**

  실제 타이머의 기능을 수행하는 클래스

- **TimerTask**

  클래스가 수행되어야할 내용을 작성하는 클래스



```java
package com.lex.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx extends TimerTask {

	@Override
	public void run() {
		// 작업정의
		System.out.println("* * *");
		
	}

}
```

```java
package com.lex.ex07_timer;

import java.util.Timer;

public class TimerTestMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); // 프로그램 종료시 timer가 메모리에 상주하지 않음
		TimerTaskEx01 task1 = new TimerTaskEx();
		TimerTaskEx02 task2 = new TimerTaskEx();
		// 2초후에 task1.run() 수행
		timer.schedule(task1, 2000);
		// 1초 후부터 0.5초마다 task2.run() 수행
		timer.schedule(task2, 1000, 500);
		
	}
	
}
```
