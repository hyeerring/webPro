## [10] 문서객체모델

문서 객체 모델(DOM, Document Object Model)은 XML이나 HTML 문서에 접근하기 위한 일종의 인터페이스이다. 이 객체 모델은 문서 내의 모든 요소를 정의하고, 각각의 요소에 접근하는 방법을 제공한다.

HTML 페이지는 아래와 같이 트리 모양의 문서 객체 모델로 나타낼 수 있고 각 요소를 노드라 부른다.

```mermaid
stateDiagram-v2
html --> head
head --> title
title --> "index"

html --> body
body --> hl
hl --> "textNode"

body --> img
```

### 문서 객체 만들기

#### 텍스트 노드를 갖는 문서 객체 생성

1. **Document 객체의 노드 생성 메소드**

| 메소드 이름            | 설명                    |
| ---------------------- | ----------------------- |
| createElement(tagName) | 요소 노드를 생성한다.   |
| createTextNode(text)   | 텍스트 노드를 생성한다. |

2. **문서 객체의 연결 메소드**

| 메소드 이름       | 설명                    |
| ----------------- | ----------------------- |
| appendChild(node) | 객체에 노드를 연결한다. |

----

#### 텍스트 노드를 갖지 않는 문서 객체 생성

| 메소드이름                | 설명                    |
| ------------------------- | ----------------------- |
| setAttribute(name, value) | 객체의 속성을 지정한다. |
| getAttribute(name)        | 객체의 속성을 가져온다. |



```javascript
window.onload = function () {
// 1) 텍스트 노드를 갖는 문서 객체 생성
// 1.h1태그 생성 2.textNode 생성 3.textNode를 h1태그에 연결 4.h1태그를 body에 추가
    var h1 = document.createElement('h1');
    var textNode = document.createTextNode('Hello, World!');
    h1.appendChild(textNode);
    document.body.appendChild(h1);
// 2) 텍스트 노드를 갖지 않는 문서 객체 생성
// 1.img태그 생성 2.src속성 변경 3.body에 img태그를 추가
    var img = document.createElement('img');
    img.setAttribute('src', 'img/red.jpg');
    document.body.appendChild(img);
// 3) innerHTML 이용
    document.body.innerHTML += '<h1>innerHTML</h1>'
};
```



## HTML 요소의 선택

| 메소드 이름                         | 설명                                                     |
| ----------------------------------- | -------------------------------------------------------- |
| getElementById(id)                  | id와 일치하는 문서 객체를 선택한다.                      |
| getElementsByClassName('className') | class명과 일치하는 문서 객체들을 배열로 반환한다.        |
| getElementsByName('name')           | name 속성이 일치하는 문서 객체들을 배열로 반환한다.      |
| getElementsByTagName(‘tagName’)     | tag명과 일치하는 문서 객체들을 배열로 반환한다.          |
| document.querySelector(선택자)      | 해당 선택자로 처음 선택되는 문서 객체를 한개를 반환한다. |
| document.querySelectorAll(선택자)   | 해당 선택자로 선택되는 문서 객체를 배열로 반환한다.      |

```javascript
<script>
    document.getElementById('wrap');
    document.getElementsByTagName('div')[0];
    document.querySelector('div#wrap');
    document.querySelectorAll('div#wrap')[0];
</script>
<body>
    <div id="wrap">
    </div>
</body>
```

