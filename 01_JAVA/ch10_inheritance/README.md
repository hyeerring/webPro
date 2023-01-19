## [10] Inheritance 상속

상속이란 부모클래스가 가지고 있는 속성과 메서드를 물려받아 활용할 수 있는 개념이다.

부모 클래스(상위 클래스)와 자식클래스(하위 클래스)가 있으며, 자식 클래스는 부모 클래스를 상속받아 쓸 수 있다. 상속은 이미 마련되어 있는 클래스를 재사용하여 만들 수 있기 때문에 효율적이며 개발 시간을 줄여준다.



### 상속 문법

```java
접근제어자 (final/abstract) class 클래스이름 extends 상위클래스{
	// 필드
  // 생성자
  // 메소드
}
```

💡다른 언어와 달리 자바는 다중 상속을 허용하지 않는다.



### 상속의 장점

- 기존 클래스의 변수와 코드를 재사용할 수 있어 개발 시간이 단축된다.

- 먼저 작성된 검증된 프로그램을 재사용하기 때문에 신뢰성있는 프로그램을 개발할 수 있다.

- 클래스 간 계층적 분류 및 관리가 가능하여 유지보수가 용이하다.

  

💡**Object 클래스**

모든 클래스의 최상위 클래스로 자바에서 만드는 모든 클래스는 Object 클래스를 상속받는다. 따라서 자바에서 만드는 모든 객체는 Object 자료형으로 사용할 수 있다.



### 메소드 오버라이딩(Method overriding)

부모클래스에서 선언된 메소드와 같은 이름, 같은 리턴타입, 같은 매개 변수 리스트를 갖는 메소드를 자식 클래스에서 재작성 하는 것이다. 즉, 메소드 오버라이딩은 **상속받은 부모클래스의 메소드를 재정의**하여 사용하는 것을 의미한다.

**오버라이딩 조건**

- 부모클래스의 메소드와 동일한 이름, 동일한 매개변수 타입, 동일한 리턴타입을 갖는 메소드를 작성해야한다.
- 부모클래스 메소드의 접근지정자보다 접근의 범위를 좁혀 오버라이딩 할 수 없다.
- Static이나 private 또는 final로 선언된 메소드는 자식클래스에서 오버라이딩 할 수 없다.



### 메소드 오버로딩(Method overloading)

입력이 다른 경우 동일한 이름의 메서드를 만들 수 있는데 이를 메소드 오버로딩이라고 한다.