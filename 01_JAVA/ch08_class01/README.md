## [08] Class

**💡클래스란?**

객체를 정의하는 틀 또는 설계도와 같은 의미로 사용된다. Java에서는 이러한 클래스를 가지고 여러 객체를 생성하여 사용하게 된다. 클래스는 객체의 상태를 나타내는 필드(Field)와 객체의 행동을 나타내는 메소드(Mmethod)로 구성된다.



### 클래스의 구조

| 클래스의 구성       | 설명                                                         |
| ------------------- | ------------------------------------------------------------ |
| 필드(Field)         | 객체의 데이터가 저장되는 곳                                  |
| 생성자(Constructor) | new 연산자로 호출되는 메소드로 객체 생성 시 필드의 초기화를 담당 |
| 메소드(Method)      | 객체의 동작에 해당하며 클래스의 다양한 동작을 구성           |



### 클래스 선언

```java
public class Sample{ // 클래스명의 앞글자는 대문자로 작성
    
  }
```

```java
public class Member {
	// 필드(Field)
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	
  // 생성자
	public Member() {
	}
	
	public Member(String id, String pw, String name, String email, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public String infoString() {
		String result = "아이디 = " + id;
		result += "\n비밀번호 = " + pw;
		result += "\n이름 = " + name;
		result += "\n이메일 = " + email;
		result += "\n주소 = " + address;
		return result;
	}
	
}

```



**💡 생성자의 이해**

생성자는 매개변수가 있는 생성자와 매개변수가 없는 생성자 등 여러 종류의 생성자를 가질 수 있다. 생성자가 없을 때는 디폴트 생성자가 컴파일러 단계에서 자동 생성한다. 한 개 이상의 생성자가 있으면 디폴트 생성자는 자동 생성되지 않는다.