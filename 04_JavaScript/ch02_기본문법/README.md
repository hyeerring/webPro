## [02] 기본문법

### JavaScript 에서의 변수 선언

**var**

- 원조 변수선언방식. 선언한 변수가 동일한 이름으로 중복 선언이 가능하며 마지막에 할당된 값이 최종 변수에 저장된다. 
- 변수를 유연하게 사용할 수 있지만, 기존에 선언해 둔 변수의 존재를 잊고 재선언 하는 경우 문제가 발생할 수 있다.

**let**

- 중복선언 불가. 재할당 가능
- 함수, if절 외 for, while, try/catch등 모든 코드블록 ({..}) 내부에서 선언된 변수는 코드 블록 내부에서만 유효. 블록 외부부터 참조 불가. 
- 재할당이 필요한 경우 한정적으로 `let`을 사용하는 것이 좋다. 단, 이 때 변수의 스코프는 최대한 좁게 만드는 것이 좋다. 

**const**

- 중복선언 불가. 재할당 불가.
- let과 마찬가지로 함수, 코드블록 ({..}) 내부에서 선언된 변수는 코드 블록 내부에서만 유효하다. 블록 외부부터 참조 불가. 
- 재할당이 필요없는 상수과 객체에는 기본적으로 `const`를 사용하는 것이 좋다.



## 자료형

자바스크립트에서 값은 문자열이나 숫자형같은 특정한 자료형에 속한다.



### 문자열 자료형

```javascript
let str1 = "Hello";
let str2 = 'Hello';

alert(‘This is “Spring”’);
```

자바스크립트에서는 문자열(String)을 따옴표로 묶는다. 이때 큰따옴표나 작은 따옴표를 모두 이용할 수 있으며, 항상 일관되게 따옴표를 사용하는 것을 추천한다. 

그러나 문자열 안에 따옴표를 사용해야 한다면 예외적으로 두 가지를 모두 사용한다.



### 숫자 자료형

```javascript
<script>
    var i = 10/3;
    alert(i);
    alert(5 + 3 * 2);
    alert(10 % 7);
</script>
```

정수와 유리수의 구분 없이 사용하며 %(나머지 연산자)와 사칙연산이 가능하다.

숫자형엔 일반적인 숫자 외에 `Infinity`, `-Infinity`, `NaN`같은 '특수 숫자 값(special numeric value)'이 포함된다.



### Boolean 자료형

논리적인 요소를 나타내며 `true`와 `false` 두가지 값을 가질 수 있다. 비어있는 문자열과 `null`, `undefined`, ` 0`은 false로 간주된다.

- 비교연산자 (!= 다르다) 등을 이용하여 불 자료형을 만들 수 있다.
- 논리연산자 (! 부정연산자, && 논리곱연산자, || 논리합연산자)



### Undefined 자료형

변수를 선언하지 않았거나 선언했어도 초기화하지 않았을 때 undefined 자료형을 가진다.



### 자료형 검사

```javascript
var variable;
variable = 'Hello';
document.write(typeof(variable)); // string 
variable = 10;
document.write(typeof(variable)); // number 
```



## 입출력

자바스크립트에 내장된 대화 상자를 이용한 인터페이스

1. **alert 함수** : 경고 메시지를 전달하기 위한 대화상자를 표시

2. **confirm함수** : 사용자의 확인을 받기 위한 대화상자를 표시

```javascript
//반환값이 true면 확인이, false면 취소가 선택된 것
// 반환값 = confirm(출력할 메시지);

<script>
    answer = confirm("수강신청을 하시겠습니까?");
        if (answer == true)
            alert("등록 되었습니다.");
        else
            alert("취소 되었습니다.");
</script>
```



3. **prompt 함수** : 사용자로부터 내용을 입력받을 수 있는 대화 상자를 표시. 데이터를 키보드에서 입력받고 싶을 때 사용.

```javascript
// 반환값 = prompt(메시지, 초기값);

<script>
    name = prompt("이름을 입력하세요.", "홍길동");
	alert(name + "님 환영합니다.");
</script>
```



## 형변환

- **Number(value)** : 다른 자료형을 숫자로 변환. 숫자로 표시할 수 없는 일반 문자열을 강제로 숫자 자료형으로 바꿨을 시 `NaN`으로 출력.

  > 💡`null`과 `undefined`는 숫자형으로 변환 시 결과가 다르다. `null`은 `0`이 되고 `undefined`는 `NaN`이 된다.

- **parseInt(string, [진수])와 parseFloat(string)** : 문자열을 정수와 실수로 변경. 문자열 타입의 숫자만 가능

- **String(value)** : 다른 자료형을 문자열로 바꿀 때

- **isNaN(숫자)** : 주어진 데이터가 숫자면 `false`리턴, 숫자가 아니면 `true`리턴

```javascript
<script>
    // 문자열
    str = '100점';
    i = Number(str);
    document.write(typeof (i) + '값: ' + i); // number값: NaN

    str = '100점';
    i = parseInt(str);
    document.write(typeof (i) + '값: ' + i); // number값: 100
	
	// 문자
    str = 'B';
    i = Number(str);
    document.write(typeof (i) + '값: ' + i); // number값: NaN

    str = 'B';
    i = parseInt(str, 16);
    document.write(typeof (i) + '값: ' + i); // number값: 11

    // 빈스트링
    str = '';
    i = Number(str);
    document.write(typeof (i) + '값: ' + i); // number값: 0

    str = '';
    i = parseInt(str);
    document.write(typeof (i) + '값: ' + i); // number값: NaN
</script>
```

