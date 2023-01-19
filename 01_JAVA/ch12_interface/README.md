## [12] Interface 인터페이스

💡 **인터페이스(interface)란?**

인터페이스(interface)란 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서, 다른 클래스 사이의 중간 매개 역할까지 담당하는 일종의 추상 클래스를 의미한다.

자바에서 추상 클래스는 추상 메소드뿐만 아니라 생성자, 필드, 일반 메소드도 포함할 수 있습니다. 하지만 인터페이스(interface)는 오로지 추상 메소드와 상수만을 포함할 수 있습니다.



### 인터페이스 문법

- `class` 대신 `interface` 예약어를 사용한다는 점에서 클래스와 유사하다
- 실제 구현된 기능없이 추상메소드와 상수만이 존재

```java
public interface 인터페이스명 {
	public static final 타입 상수명 = 값;
  ...
	public abstract 메소드명(매개변수 목록); // 구현된 메소드는 가질 수 없다.
  ...
}
```

- 모든 멤버변수는 `public static final`이어야하며 `static final`은 생략할 수 있다.
- 상수나 메소드를 만들때 `private` 접근제한자는 불가하다.
- 인터페이스는 객체를 생성할 수 없다. 다만 변수타입으로 사용된다.
- 인터페이스명으로 실행해야한다. 구현은 `Implement` 되는 클래스에서 한다.



### 인터페이스 장점

-  **개발시간을 단축시킬 수 있다.**

  일단 인터페이스가 작성되면, 이를 사용해서 프로그램을 작성하는 것이 가능하다. 메서드를 호출하는 쪽에서는 메서드의 내용에 관계없이 선언부만 알면 되기 때문이다. 그리고 동시에 다른 한 쪽에서는 인터페이스를 구현하는 클래스를 작성하도록 하여, 인터페이스를 구현하는 클래스가 작성될 때까지 기다리지 않고도 양쪽에서 동시에 개발을 진행할 수 있다.

- **표준화가 가능하다.**

  프로젝트에 사용되는 기본 틀을 인터페이스로 작성한 다음, 개발자들에게 인터페이스를 구현하여 프로그램을 작성하도록 함으로써 보다 일관되고 정형화된 프로그램의 개발이 가능하다

- **서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.**

  서로 상속 관계에 있지도 않고, 같은 조상클래스를 가지고 있지 않은 서로 아무런 관계도 없는 클래스들에게 하나의 인터페이스를 공통적으로 구현하도록 함으로서 관계를 맺어 줄 수 있다.

- **독립적인 프로그래밍이 가능하다.**

  인터페이스를 이용하면 클래스의 선언과 구현을 분리시킬 수 있기 때문에 실제 구현에 독립적인 프로그램을 작성하는 것이 가능하다. 클래스와 클래스간의 직접적인 관계를 인터페이스를 이용해서 간접적인 관계로 변경하면, 한 클래스의 변경이 관련된 다른 클래스에 영향을 미치지 않는 독립적인 프로그래밍이 가능하다.



### 다형성

하나의 객체나 메소드가 여러가지 다른 형태를 가질 수 있는 것을 말한다. 자바에서 다형성을 나타내는 것으로는 오버라이딩과 오버로딩 그리고 상속받은 객체의 참조변수 형변환 등이 있다.



### 인터페이스와 다중상속

Java는 다중상속이 불가하다. C++에서는 다중상속이 가능하였으나, java에서는 다중상속이 불가능하다. 이유는 C++에서 다중상속을 가능하게 하여 좋은 점도 있었으나, 다중상속으로 인한 문제점도 많았기 때문에 C++에서 발전된 java 에서는 다중상속을 불가하게 했다. 하지만 java에서도 interface를 통해서는 다중구현이 가능하여, 여러 가지 타입으로 객체를 선언할 수 있다. 

정확하게 말하면 java는 다중상속이 아닌 ‘다형성(type이 다양하게 존재할 수 있다)’이 존재한다고 이해해야 한다. 인터페이스를 구현하는 것은 클래스를 상속받는 것과 비슷하지만, `extends` 대신 `implements`를 사용한다.

|                       |   단일   |   다중   |
| :-------------------: | :------: | :------: |
|     Class ◀️ Class     | 단일상속 | 다중상속 |
|   interface ⬅️ Class   | 단일구현 | 다중구현 |
| interface ◀️ interface | 단일상속 | 다중상속 |