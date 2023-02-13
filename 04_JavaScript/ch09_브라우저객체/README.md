## [09] 브라우저 객체 모델

**브라우저 객체 모델(BOM)이란?**

자바스크립트를 이용하면 브라우저의 정보에 접근하거나 브라우저의 여러 기능들을 제어할 수 있다.
이때 사용할 수 있는 객체 모델이 바로 브라우저 객체 모델(BOM, Browser Object Model)이다.

브라우저 객체 모델(BOM)은 문서 객체 모델(DOM)과는 달리 W3C의 표준 객체 모델은 아니다.
하지만 이 모델은 자바스크립트가 브라우저의 기능적인 요소들을 직접 제어하고 관리할 방법을 제공해 준다. 자바스크립트에서는 이러한 BOM 모델의 객체들을 전역 객체(global object)로 사용할 수 있다.

### window 객체

window 객체는 웹 브라우저의 창(window)을 나타내는 객체로, 대부분의 웹 브라우저에서 지원하고 있다.

window 객체의 메소드는 전역 함수이며, window 객체의 프로퍼티는 전역 변수가 된다. 문서 객체 모델(DOM)의 요소들도 모두 window 객체의 프로퍼티가 된다.

**window 객체의 윈도우 생성 메소드**

- URL  열고자하는 HTML 페이지의 URL
- name  윈도우 간의 통신에 사용하는 윈도우 이름 또는 target 속성
- features  윈도우 출력 모양을 지정하는 옵션

| 메소드 이름                        | 설명                           |
| ---------------------------------- | ------------------------------ |
| open(URL, name, features, replace) | 새로운 window 객체를 생성한다. |

```javascript
var child = open('', '', 'width=500, height=300');

//window 객체의 open( ) 메소드의 매개변수는 모두 옵션이다.
// URL	열고자하는 HTML 페이지의 URL
// name	윈도우 간의 통신에 사용하는 윈도우 이름 또는 target 속성
// features	윈도우 출력 모양을 지정하는 옵션

if (child) {
    child.document.write('<h1>새로운 창</h1>');
} else {
    alert('팝업 차단을 해제해 주세요.')
};
```



### location 객체

**location 객체의 메소드**

| 속성 이름     | 설명                  |
| ------------- | --------------------- |
| assign(link)  | 현재 위치를 이동한다. |
| reload( )     | 새로고침한다.         |
| replace(link) | 현재 위치를 이동한다. |

location 객체는 페이지를 이동할 때 많이 사용한다. 다음 네가지 방법으로 페이지를 이동할 수 있으나 `assign( )` 메서드와 다르게 `replace( )`메서드는 뒤로 가기 버튼을 사용할 수 없다.

```javascript
location = ‘http://www.google.com/’;
location.href = ‘http://www.google.com/’;
location.assign(‘http://www.google.com/’);
location.replace(‘http://www.google.com/’);
```



### history 객체

💡**history 객체를 이용한 뒤로가기 버튼**

```javascript
<script>
function historyBack() {
    // history.back();
    history.go(-1);
}
</script>
<body>
    <button onclick="historyBack()">뒤로가기</button>
</body>
```

