## [06] 객체

### 객체(Object)

자바스크립트의 기본 타입(data type)은 객체(object)이다. 객체란 이름(name)과 값(value)으로 구성된 프로퍼티(property)의 정렬되지 않은 집합이며, 프로퍼티의 값으로 함수가 올 수도 있는데, 이러한 프로퍼티를 메소드(method)라고 한다.

자바스크립트에서는 숫자, 문자열, 불린, undefined 타입을 제외한 모든 것이 객체이다. 하지만 숫자, 문자열, 불린과 같은 원시 타입은 값이 정해진 객체로 취급되어, 객체로서의 특징도 함께 가지게 된다.



### 속성과 메소드

배열 내부에 있는 값을 요소(element). 객체 내부에 있는 값은 속성(property). 자바 스크립트에서는 요소와 속성을 구분하지 않고 쓴다. 객체 속성 중 함수형 자료형인 속성을 메소드라고 부른다.

메소드 내에서는 `this`를 사용해야 하며, 사용하지 않을 시 객체 밖에 있는 변수를 가져온다.

```javascript
let name = "김길동";
let person = {
    name: "이길동", // 속성변수
    age: 20,
    eat: function (food) {
        var msg = this.age + "살 " + this.name + "은 " + food + "를 좋아한다.";
        alert(msg);
    },
};
person.eat("햄버거"); // 20살 이길동은 햄버거를 좋아한다.
```



### 객체와 반복문

배열은 for 반복문과 for-in 반복문으로 요소에 쉽게 접근이 가능하다. 하지만 객체는 for 문은 불가하며 for-in 반복문을 사용한다.

**for-in문**

```javascript
arr = [10,20,30]; // 배열출력
for(var idx in arr){
	document.write(arr[idx] + '<br>');
}
```

**for-of문**

```javascript
for(var data of arr){
   document.write(data + '<br>');
}
```



### 객체의 속성 추가와 제거

**속성 추가**

- 객체를 먼저 생성 후, 속성을 추후에 입력하여 추가

- 동적으로 객체의 속성 추가: Dot Notation, Bracket Notation 표기법으로 속성 추가 가능.

```javascript
let student = {};        // student 빈 객체 선언

// 1. Dot Notation 표기법
student.name = 'kim';   // 'name' key에 'kim'라는 value 추가
student.age = 20;          // 'age' key에 20이라는 value 추가
student.add = 'Seoul';   // 'add' key에 'Seoul'라는 value 추가

// 2. Bracket Notation 표기법
student['name'] = 'kim';
student['age'] = 20;
student['add'] = 'Seoul';

// 3. 정적으로 객체 속성 추가
// 객체를 생성할 때 속성도 같이 생성
let obj = { name: "kim", age: 20, add: "Seoul", }; 
```

**속성 제거**

```javascript
delete 객체명.속성명;
delete 객체명['속성명'];

delete student.add;
```



### 문자열 항목 바꾸기

1. **split( ), join( ) 메소드 사용**

문자열을 배열로 변환한 다음 문자열로 바꾸는 방법

```javascript
// 00 --> ' ' 교체
var str = '안녕하세요.00반갑습니다.00좋은하루00되세요.';
var splitStr = str.split('00'); // ['안녕하세요.', '반갑습니다.', '좋은하루', '되세요.']
var joinStr = splitStr.join(' ');
console.log(joinStr); // 안녕하세요. 반갑습니다. 좋은하루 되세요.
```

2. **replace( ) 메소드 사용**

문자열 내의 특정 문자열을 치환하기 위하여 사용하는 메소드. `replace( )` 함수는 첫 번째로 찾은 문자열만 치환해 주기 때문에 모든 문자열을 치환하고 싶을 때에는 `replaceAll( )` 함수를 사용하면 된다.

```javascript
string.replace(oldStr, newStr);
```

