## [04] 반복문

### 배열

자바스크립트에서 배열 방의 크기는 가변적. 어떤 자료형도 배열 요소가 될 수 있다.

```javascript
var array = [111, 'hello', true, function () { }, [1, 2, 3]]
```



### 배열함수

```javascript
// array.push(): 배열의 마지막 방에 추가
// array.unshift(): 배열 맨 앞에 추가
// array.pop(): 마지막 배열방의 값을 return하고 삭제
// shift(): 배열 맨 앞의 값을 제거.
// slice(인덱스, 추출할 요소의 개수): 배열 추출
// splice(인덱스, 제거할 요소의 개수): 원본 배열 수정

let arr = ['가', '라', '나', '라', '다', '라'];

// slice는 원본 배열은 바꾸지 않고 새로운 배열을 만든다.
let copyArr = arr.slice(2, 5); // 2번째부터 5번째 앞까지
document.write(copyArr + '<br>'); // 나, 라, 다

// splice는 원본 배열을 수정
for (let i = 0; i < arr.length; i++) {
    if (arr[i] == '라') {
        arr.splice(i, 1);
    }
}
document.write(arr + '<br>'); // 가, 나, 다
```



### 배열 출력

### while문

while 문은 루프에 진입하기 전에 먼저 표현식부터 검사한다. 하지만 do-while 문은 먼저 루프를 한 번 실행한 후에 표현식을 검사한다. 즉, do-while 문은 표현식의 결과와 상관없이 무조건 한 번은 루프를 실행한다.

```javascript
do {
    표현식의 결과가 참인 동안 반복적으로 실행하고자 하는 실행문;
} while (표현식);
```



### for문

for 문은 while 문과는 달리 자체적으로 초기식, 표현식, 증감식을 모두 포함하고 있는 반복문이다. 따라서 while 문보다는 좀 더 간결하게 반복문을 표현할 수 있습니다.

1. **일반 for문**

```javascript
for (var idx = 0; idx < students.length; idx++) {
    document.write(idx + "번째 " + students[idx] + '<br>');
}

var out = " ";
for (var idx = 0; idx < students.length; idx++) {
    out += idx + "번째 ";
    out += students[idx];
}
```

2. **for-in문**

   for-in 문은 해당 객체의 모든 열거할 수 있는 프로퍼티(enumerable properties)를 순회할 수 있도록 해줍니다.

```javascript
for (var idx in students) {
    document.write(idx + "번째" + students[idx] + "<br>");
}
```

3. **for-of문** : index가 없음, data복사

```javascript
for (var stu of students) {
    document.write(stu + "<br>");
}
```

4. **for-Each함수**

```javascript
// for-Each(data, index)
students.forEach(function (data, idx) {
    document.write(idx + "번째" + data + "<br>");
});

// for-Each(data, index) : 배열 반복시 index가 필요 없을 때
students.forEach(function (data) {
    document.write(data + "<br>");
});
```



**💡 숫자 금액표시 : 숫자 세자리마다 콤마 넣는 방법**

```javascript
var cntStr = String(cnt);
var temp = cntStr.length % 3;
for (var idx = 0; idx < cntStr.length; idx++) {
    if (temp == 0) {
        temp = 3;
        if (idx != 0) {
            document.write(',');
        }
    }
    document.write(cntStr[idx]);
    temp--;
}
```

