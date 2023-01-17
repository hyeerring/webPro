## [05] Array

배열은 동일 자료형의 집합을 뜻한다.

- 하나의 데이터만 가지고 있던 변수와 달리 여러개의 데이터를 저장한 곳의 주소를 가르킨다.
- 여러개의 변수를 모아 놓은 또 하나의 변수라고 볼 수 있다.

```java
int[] odds = { 1, 3, 5, 7, 9 };
```

```java
String[] weeks = { "월", "화", "수", "목", "금", "토", "일" };
```



💡 **배열의 길이는 고정되어 있다.**

```java
String[] weeks = new String[7];
	weeks[0] = "월";
	weeks[1] = "화";
	weeks[2] = "수";
	weeks[3] = "목";
	weeks[4] = "금";
	weeks[5] = "토";
	weeks[6] = "일";
```



### 배열의 문법

- `{ }`를 이용하여 초기화한다.
- 배열의 크기는 최초에 한번 설정되면 변경이 불가하다.
- 배열을 객체로 취급한다.
- 배열선언 ➡️ 배열의 메모리 할당 ➡️ 배열이용