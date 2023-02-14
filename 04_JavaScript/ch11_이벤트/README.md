## [11] EVENT

자바스크립트에서 DOM을 통해 동적인 화면처리를 위해 처리하는 내용



### 이벤트 리스너(event listener), 이벤트 핸들러(event handler)

어떤 이벤트가 발생했을 때 이를 처리하는 함수를 이벤트 리스너 또는 이벤트 핸들러라고 한다. 이벤트 앞에 `on`을 붙여 사용한다. 이벤트 등록 방법은 현재까지는 3가지가 있다.

| 이벤트를 객체와 연결하는 방식 |             | 특징                                         |
| ----------------------------- | ----------- | -------------------------------------------- |
| 인라인 이벤트 모델            | DOM Level 0 | 동일한 객체에 동일한 이벤트 여러번 적용 불가 |
| 고전 이벤트 모델              | DOM Level 0 | 동일한 객체에 동일한 이벤트 여러번 적용 불가 |
| 표준 이벤트 모델              | DOM Level 2 | DOM Level 0의 단점을 보완하기 위한 것        |



1. **인라인 이벤트 모델**

인라인 방식은 이벤트를 HTML 요소의 속성으로 직접 지정하는 방식

```javascript
<tagName onEvent = code> </tagName>
```

```javascript
// 이벤트 이름: click, 이벤트 속성: onclick, 이벤트리스너: whenClick() 함수
<script>
  function whenClick() {
    alert("반갑습니다.");
  }
</script>
<body>
<h1 onclick="whenClick()">Click Me!</h1>
</body>
```

2. **기본 이벤트 모델(고전적 이벤트 모델)**

```javascript
<script>
window.onload = function () {
    var header = document.getElementById("header");
    header.onclick = function () {
        alert("반갑습니다.");
    };
};
</script>
<body>
<h1 id="header">Click Me!</h1>
</body>
```

3. **표준 이벤트 모델**

```javascript
<script>
window.onload = function () {
    var header = document.getElementById("header");
    header.addEventListener("click", () => {
        alert("반갑습니다.");
    });
};
</script>
<body>
<h1 id="header">Click Me!</h1>
</body>
```



### 이벤트 타입(Event Type)

1. **마우스 이벤트**

| 이벤트      | 설명                                                |
| ----------- | --------------------------------------------------- |
| click       | 요소에 마우스를 클릭했을 때 이벤트 발생             |
| dbclick     | 요소에 마우스를 더블클릭했을 때 이벤트 발생         |
| mouseover   | 요소에 마우스 포인터가 오버했을 때 이벤트 발생      |
| mouseout    | 요소에 마우스 포인터가  아웃했을 때 이벤트 발생     |
| mousedown   | 마우스를 클릭할 때 이벤트 발생                      |
| mouseup     | 마우스를 클릭한 후 뗄 때 이벤트 발생                |
| mousemove   | 마우스가 해당 요소 내를 움직일 때 이벤트 발생       |
| contextmenu | 마우스를 우클릭 시 콘텐츠 메뉴가 보이기 직전에 발생 |

2. **키보드 이벤트**

| 이벤트   | 설명                                           |
| -------- | ---------------------------------------------- |
| keydown  | 키보드를 눌렀을 때 이벤트 발생                 |
| keyup    | 키보드를 눌렀다가 뗄 때 이벤트 발생            |
| keypress | 키보드를 눌러 문자가 연결되었을 때 이벤트 발생 |

3. **폼 이벤트**

| 이벤트 | 설명                                                         |
| ------ | ------------------------------------------------------------ |
| focus  | 해당 요소를 클릭, 마우스 커서를 놓는 등 요소에 포커스 되었을 때 이벤트 발생 |
| blur   | 요소에 포커스가 벗어났을 때 이벤트 발생                      |
| change | 요소 값이 변경 되었을 때 이벤트 발생                         |
| submit | submit 버튼을 눌렀을 때 이벤트 발생                          |
| reset  | reset 버튼을 눌렀을 때 이벤트 발생                           |
| select | input이나 textarea 요소 안의 텍스트를 드래그하여 선택했을 때 이벤트 발생 |

4. **문서(document) / 창(window) 이벤트**

| 이벤트 | 설명                                       |
| ------ | ------------------------------------------ |
| load   | 페이지의 로딩이 완료되었을 때 이벤트 발생  |
| abort  | 이미지의 로딩이 중단되었을 때 이벤트 발생  |
| unload | 페이지가 다른 곳으로 이동될 때 이벤트 발생 |
| resize | 요소에 사이즈가 변경되었을 때 이벤트 발생  |
| scroll | 스크롤바를 움직였을 때 이벤트 발생         |

