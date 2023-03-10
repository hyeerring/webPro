## [03] 조건문

#### 조건문(conditional statements)

조건문이란 프로그램 내에서 주어진 표현식의 결과에 따라 별도의 명령을 수행하도록 제어하는 실행문이다. 자바스크립트에서 사용할 수 있는 조건문의 형태는 다음과 같다.

1. **if 조건문**

   if 문은 표현식의 결과가 참(true)이면 주어진 실행문을 실행하며, 거짓(false)이면 아무것도 실행하지 않는다.

2. **if else 조건문**

   if 문과 같이 사용할 수 있는 else 문은 if 문의 표현식 결과가 거짓(false)일 때 주어진 실행문을 실행한다.

3. **else if 조건문**

   else if 문은 if 문처럼 표현식을 설정할 수 있으므로, 중첩된 if 문을 좀 더 간결하게 표현할 수 있다. 하나의 조건문 안에서 if 문과 else 문은 단 한 번만 사용될 수 있지만 else if 문은 여러 번 사용되어 다양한 조건을 설정할 수 있다.

4. **switch 조건문**

   switch 문은 if / else 문과 마찬가지로 주어진 조건 값에 따라 프로그램이 다른 명령을 수행하도록 하는 조건문이다. 이러한 switch 문은 if / else 문보다 가독성 측면에서 더 좋다.

   

### 삼항연산자

자바스크립트에서는 간단한 if / else 문을 삼항 연산자를 이용하여 간단히 표현할 수 있다.

```javascript
(표현식) ? (반환값1) : (반환값2);
```



### 짧은 조건문

논리연산자의 특성을 조건문으로 사용한다. 

다음 논리합 연산자를 사용한 표현식은 뒤에 어떠한 값이 들어가도 항상 참이다. 자바스크립트는 참`true` 이 확실할 때 추가 연산을 진행하지 않아서 논리합 연산자의 좌변이 참이면 우변을 실행하지 않는다

```javascript
// 불 표현식 || 불 표현식이 거짓일 때 실행할 문장
true || OOO
```

