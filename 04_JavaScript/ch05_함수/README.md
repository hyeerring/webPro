## [05] 함수

### 익명함수(Anonymous function)

자바스크립트 익명 함수는 함수명 대신 변수명에 함수 코드를 저장하는 구현 방식이다. 익명 함수의 소스 코드는 변수값이므로 끝에 세미콜론 `;` 을 대입한다. 익명 함수는 호출 시 변수명을 함수명처럼 사용하면 된다.

```javascript
var functionVar = function() {...}; // 함수 표현식
var functionVar = () => {...}; // 화살표 함수
                         
// 매개변수 지정 방법
() => {...} // 매개변수가 없을 경우
value => {...} //매개변수가 한 개인 경우, 소괄호를 생략할 수 있다
(x, y) => {...} // 매개변수가 여러 개인 경우, 소괄호를 생략할 수 없다
```



### 선언적 함수(Function statement)

선언적 함수는 함수를 선언할 때 이름을 붙여주는 함수를 말한다. 즉, 따로 변수에 넣어주지 않고 선언할 대 붙여준 이름으로 호출하면 된다.

**💡익명함수와 선언적 함수의 차이**

자바스크립트에서 함수를 선언하는 방법은 위에서 설명한대로 익명 함수와 선언적 함수로 선언하는 방법 두가지 이다. 둘 다 함수를 생성하는 방법이지만, 차이는 있다.

선언적 함수는 script 태그 내부의 내용을 읽기 전에 선언적 함수부터 먼저 읽기 때문에 함수 호출 선언 전에 호출을 해도 실행이 가능하다.

```javascript
fun();
function fun() { alert('함수  A'); } //웹브라우저는 script 태그 내부의 내용을 읽기전에 선언적 함수부터 읽는다.
```



### 가변 인자 함수

매개변수를 선언된 형태와 다르게 사용했을 때, 매개변수를 모두 활용할 수 있는 함수이다. `arguments`는 가상 공간에 변수 값을 지정하여 배열 형태로 사용합니다. 화살표함수 사용 불가.

```javascript
function array() { // arguments 배열에 실행 시의 매개변수가 들어옴
    var result = [];
    if (arguments.length == 1) {
        for (var cnt = 1; cnt <= arguments[0]; cnt++) {
            result.push(null);
        } // for
    } else if (arguments.length >= 2) {
        for (var idx in arguments) {
            result.push(arguments[idx]);
        }
    }
    return result;
}
```



### 내부함수(Inner function)

다른 라이브러리와의 충돌을 막기 위해 함수 내에 선언된 함수

```javascript
function pythagoras(width, height) {
    function square(x) {
        return x * x;
    }
    return Math.sqrt(square(width) + square(height));
}
```

**💡 자기 호출 함수**

다른 개발자에게 영향을 주지 않도록 생성하자마자 호출하는 함수

```javascript
(function(){...})();
```



### 콜백함수(Callback function)

파라미터로 전달받은 함수. 파라미터로 콜백함수를 전달받고 함수 내부에서 필요할 때 콜백함수를 호출할 수 있다.

```javascript
function callTenTimes(callback) {
    for (var i = 0; i < 10; i++) {
      callback(); // 콜백함수(매개변수에 들어온 함수)
    }
}
var funVar = function () {
    document.write(new Date() + "<br>");
    };
callTenTimes(funVar);
```



### 클로저(Closure)

클로저(Closure)는 자유변수에 접근할 수 있는 내부함수 또는 그 환경을 포함하는 코드를 지칭한다.

```javascript
function test(name) {
    var msg = "Hello, " + name + "님 반갑습니다.";
    var fun = function () {
      alert(msg);
    };
    return fun; // 클로저함수 return
}
test("홍길동")(); // 리턴받은 클로저함수를 바로 실행
```



## 내장함수

### 타이머함수

- **setTimeout(function, millisecond)** : 일정시간 후 함수를 한번 실행
- **setInterval(function, millisecond)** : 일정시간마다 함수를 반복해서 실행
- **clearTimeout(id)** : setTimeout 중지
- **clearInterval(id)** : setInterval 중지

💡타이머는 브라우저가 전부 로드된 이후에 실행된다.



### 인코딩과 디코딩 함수

인코딩은 문자를 컴퓨터에 저장하거나 통신에 사용할 목적으로 부호화하는 방법이다. 웹에서는 통신할 때 한글 같은 유니코드 문자가 오작동을 일으킬 수 있으므로 인코딩해야 한다. 문자를 부호화하는 것이 인코딩, 그 반대로 돌리는 것이 디코딩이다.

- **encodeURIComponent(uriConponent)** : 대부부의 문자를 모두 인코딩
- **decodeURIComponent(encodedURI)** :  대부분의 문자를 모두 디코딩



### 코드실행함수

- **eval(수식이나 자바스크립코드)** : 자바스크립 코드를 실행



### 숫자확인함수

- **isFinite( )** : number가 유한한 값인지 확인
- **isNaN( )** : number가 NaN인지 확인



### 숫자변환함수

- **Number( )** : 다른 자료형을 숫자로 변경하는 함수
- **parseInt( )** : 문자열을 정수와 실수로 변경하는 함수. 문자열 타입의 숫자만 가능