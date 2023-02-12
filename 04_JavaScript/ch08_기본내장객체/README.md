## [08] 기본내장객체

- **Number**  숫자 객체

- **String**  문자열을 다루기 위한 객체

- **Array**  배열을 만들어 주는 객체

- **Date**  날짜와 시간을 처리하기 위한 객체

- **Math**  수학 계산을 위한 객체



💡 **기본자료형과 객체의 차이점**

기본 자료형과 객체는 분명 다르지만 두가지 모두 값을 출력한다. 각자의 속성과 메소드도 있다. 속성과 메소드는 객체만이 가질 수 있지만 기본 자료형에도 속성과 메소드가 있다. 기본 자료형의 속성이나 메소드를 사용하면 기본 자료형이 자동으로 객체로 변환된다.

차이점을 찾자면 기본 자료형은 객체가 아니무로 속성과 메소드를 추가할 수 없다. 기본 자료형에 메소드를 추가하고자 한다면 `Number`객체의 포로토타입에 메서드를 추가하면 기본 자료형에게도 새로운 메소드가 생성된다.

```javascript
// JavaScript에서 기본데이터타입(number, string, boolean)
var priNum = 3.14; // 기본데이터타입;
// var priNum = new Number(3.14); 와 같이 실행
var objNum = new Number(3.14);

document.write('priNum의 타입 ' + typeof (priNum) + '<br>'); // priNum의 타입 number
document.write('objNum의 타입 ' + typeof (objNum) + '<br>'); // objNum의 타입 object

if (priNum.constructor == objNum.constructor) {
    document.write('priNum과 objNum의 저장된 타입은 같다.' + '<br>');
} else {
    document.write('priNum과 objNum의 저장된 타입은 다르다.' + '<br>');
} // priNum과 objNum의 저장된 타입은 같다.
```



### Object 객체

자바스크립트의 최상위 객체

```javascript
var object = {};
var object = new Object();
```

**Object 객체의 메소드**

| 메소드 이름    | 설명                           |
| -------------- | ------------------------------ |
| constructor( ) | 객체의 생성자 함수를 나타낸다. |
| toString( )    | 객체를 문자열로 바꾼다.        |
| valueOf( )     | 객체의 값을 나타낸다.          |



### Number 객체

**Number  객체의 메소드**

| 메소드 이름      | 설명                                                         |
| ---------------- | ------------------------------------------------------------ |
| toExponential( ) | 숫자를 지수 표시로 나타낸 문자열을 리턴한다.                 |
| toFixed( )       | 숫자를 고정 소수점 표시로 나타낸 문자열을 리턴한다.          |
| toPrecision( )   | 숫자를 길이에 따라 지수 표시 또는 고정 소수점 표시로 나타낸 문자열을 리턴한다. |



### String 객체

**String 객체의 속성**

| 속성 이름 | 설명                      |
| --------- | ------------------------- |
| length    | 문자열의 길이를 나타낸다. |

**String 객체의 메소드**

| 메소드 이름             | 설명                                                 |
| ----------------------- | ---------------------------------------------------- |
| charAt(position)        | position에 위치하는 문자를 리턴한다.                 |
| charCodeAt(position)    | position에 위치하는 문자의 유니코드 번호를 리턴한다. |
| concat(str)             | 매개변수로 입력한 문자열을 이어서 리턴한다.          |
| indexOf(searchStr)      | 앞에서부터 일치하는 문자열의 위치를 리턴한다.        |
| lastIndexOf(searchStr)  | 뒤에서부터 일치하는 문자열의 위치를 리턴한다.        |
| match(str)              | 문자열 내에 str이 있는지 확인한다.                   |
| replace(oldStr, newStr) | oldStr을 newStr으로 바꾼 뒤 리턴한다.                |
| search(str)             | str과 일치하는 문자열의 위치를 리턴한다.             |
| slice(start, end)       | 특정 위치의 문자열을 추출하여 리턴한다.              |
| split(char)             | char를 기준으로 문자열을 잘라서 배열로 리턴한다.     |
| substr(start, count)    | start부터 count만큼 문자열을 잘라서 리턴한다.        |
| substring(start, end)   | start부터 end까지 문자열을 잘라서 리턴한다.          |
| toLowerCase( )          | 문자열을 소문자로 바꾸어 리턴한다.                   |
| toUpperCase( )          | 문자열을 대문자로 바꾸어 리턴한다.                   |



### Array 객체

**Array 객체의 속성**

| 속성 이름 | 설명                      |
| --------- | ------------------------- |
| length    | 문자열의 길이를 나타낸다. |

**Array 객체의 메소드**

| 메소드 이름 | 설명                                                         |
| ----------- | ------------------------------------------------------------ |
| concat( )   | 매개변수로 입력한 배열의 요소를 모두 합쳐 배열을 만들어 리턴한다. |
| join( )     | 배열 안의 모든 요소를 문자열로 만들어 리턴한다.              |
| pop( )      | 배열의 마지막 요소를 제거하고 리턴한다.                      |
| push( )     | 배열의 마지막 부분에 새로운 요소를 추가한다.                 |
| reverse( )  | 배열의 요소 순서를 뒤집는다.                                 |
| slice( )    | 배열요소의 지정한 부분을 리턴한다.                           |
| sort( )     | 배열의 요소를 ascii 코드 순으로 정렬한다.                    |
| splice( )   | 배열 요소의 지정한 부분을 삭제하고 삭제한 요소를 리턴한다.   |

```javascript
// 오름차순 정렬
arr.sort(function (left, right) {
	return left - right;
});

// 내림차순 정렬
arr.sort(function (left, right) {
    return right - left;
});
```



### Date 객체

```javascript
var today = new Date();
  document.write("현재시간: " + today + "<br>"); // 현재시간: Sun Feb 12 2023 20:12:20 GMT+0900 (한국 표준시)
  document.write("현재시간: " + today.toLocaleString() + "<br>"); // 현재시간: 2023. 2. 12. 오후 8:12:20
  document.write("날짜: " + today.toLocaleDateString() + "<br>"); // 날짜: 2023. 2. 12.
  document.write("시간: " + today.toLocaleTimeString() + "<br>"); // 시간: 오후 8:12:20
```

💡**Date 객체를 이용하여 D-day 구하기**

날짜 간격을 구할 때에는 `getTime( )`함수를 사용한다. `getTime( )`함수는 1970년 1월 1일 자정부터 지난 밀리초를 계산한다. 이를 사용해 두 시간 사이의 간격을 구하고 다시 날짜로 바꿀 수 있다.

```javascript
// today.getIntervalDay(birth)
// today부터 birth까지 기간의 날짜를 return
// this = today / that = birth
Date.prototype.getIntervalDay = function (that) {
    if (this>that) {
        var intervalMilliSec = this.getTime() - that.getTime();
    } else {
        var intervalMilliSec = that.getTime() - this.getTime();
    } // this ~ that 사이의 MilliSec
    var day = intervalMilliSec / (1000*60*60*24);
    return Math.trunc(day);
};

var today = new Date();
var birth = new Date(2023, 1, 2, 12, 0, 0); // 23년 생일: 23년 2월 2일
var nextbirth = new Date(2024, 1, 2, 12, 0, 0); // 24년 생일: 24년 2월 2일

document.write(
    "생일까지 " + today.getIntervalDay(birth) + "일 남았습니다.
);
document.write(
    "내년 생일까지 " + today.getIntervalDay(nextBirth) + "일 남았습니다."
);
```



### Math 객체

**Math 객체의 메소드**

```javascript
var num = 3.1415926535;
    document.write('num: ' + num + '<br>');
    document.write('지수형표현' + num.toExponential(5) + '<br>');

// 반올림
document.write('소수점 2자리까지 반올림: ' + num.toFixed(2) + '<br>');
// Math.round(숫자): 소수점에서 반올림
document.write('소수점 1자리까지 반올림: ' + Math.round(num * 10) / 10 + '<br>');
document.write('숫자 4개만 출력: ' + num.toPrecision(4) + '<br>');
```

