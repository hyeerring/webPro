## [09] 접근제한자와 Static

### Access Modifier 접근제한자

접근제한자(Access Modifier)는 말 그대로 접근을 제한하기 위해 사용된다. 

접근 제어자는 `private -> default -> protected -> public` 순으로 보다 많은 접근을 허용한다. 

| 접근제한자 | 적용 대상                    | 접근 가능 대상               |
| ---------- | ---------------------------- | ---------------------------- |
| public     | 클래스, 필드, 생성자, 메소드 | 모든 대상                    |
| protected  | 필드, 생성자, 메소드         | 같은 패키지 또는 자식 클래스 |
| default    | 클래스, 필드, 생성자, 메소드 | 같은 패키지에 소속된 클래스  |
| private    | 필드, 생성자, 메소드         | 클래스 내부                  |

```java
package com.lec.ex03_accesstest;

public class AccessTest {
	public int publicMember; // 모든 패키지에서 접근 가능
  protected int protectedMember; // 같은 패키지나 상속받은 클래스에서 접근가능
  int defaultMember; // 디폴트 접근제한: 같은 패키지에 소속된 클래스
  private int privateMember; // 클래스내에서만 접근 가능

  	public void publicMethod() {
		System.out.println("public 메소드");
	}

	protected void protectedMethod() {
		System.out.println("protected 메소드");
	}

	void defaulMethod() {
		System.out.println("defaul 메소드");
	}
  
  private void privateMethod() {
		System.out.println("provate 메소드");
	}
  
}
```



### Static 변수

객체변수는 객체가 생성될 때마다 각 객체 안의 속성 변수들이 생성되지만, 클래스 변수는 클래스로부터 생성된 객체들의 수와 상관없이 하나만 생성된다.

한 클래스로부터 생성된 모든 객체들은 클래스 변수를 공유하며 클래스 변수를 이용하여 객체들 사이의 통신에 사용하거나 객체들의 공통속성을 나타낼 수 있다. 객체변수와 달리 클래스 변수(Static 변수)는 클래스 이름을 통하여 접근한다.



💡**static과 객체와의 관계**

클래스 하나에서 무한대로 객체를 생성할 수 있고 그러한 객체는 모양은 동일할 수 있지만 전혀 다른 객체이다. 하지만 Static이 붙은 변수는 객체 변수가 아닌 클래스 변수로서 객체가 생성되기 전에 이미 존재한다.



### Static의 장점과 단점

Static 키워드를 통해 생성된 정적멤버들은 Heap영역이 아닌 Static영역에 할당된다. Static 영역에 할당된 메모리는 모든 객체가 공유하여 하나의 멤버를 어디서든지 참조할 수 있는 장점을 가지지만 Garbage Collector의 관리 영역 밖에 존재하기에 Static영역에 있는 멤버들은 프로그램의 종료시까지 메모리가 할당된 채로 존재하게 된다. 그렇기에 Static을 너무 남발하게 되면 만들고자 하는 시스템 성능에 악영향을 줄 수 있다.
