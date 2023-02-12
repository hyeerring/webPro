## [07] 생성자함수

생성자 함수는 JavaScript에서 객체를 생성하기 위해 사용되는 특수한 함수이다. 객체를 생성하기 위해서는 직접 객체를 반환해도 되지만, new 키워드를 사용하여 함수를 호출하게되면 return 문이 없어도 새로운 객체를 반환 시킨다.

그리고 함수 에서 this를 사용하여 반환되는 객체의 초기 상태와 행위를 정의할 수 있다. 이렇게 객체를 생성하는 역할을 하는 함수를 생성자 함수라고 한다.

- 함수 이름의 첫 글자는 대문자로 시작한다.
- 반드시 `'new'` 연산자를 붙여 실행한다.
- 생성자 함수는 화살표 함수로  만들 수 없으며 오직 `function( )` 을 사용해야 한다.
- 여러개의 동일한 프로퍼티를 가지는 객체를 생성하기 위해서 필요. 

```javascript
function Student(name, kor, mat, eng) {
    this.name = name;
    this.kor = kor;
    this.mat = mat;
    this.eng = eng;
    this.getSum = function () {
        return this.kor + this.mat + this.mat + this.eng;
    };
    this.getAvg = function () {
        return this.getSum() / 3;
    };
}

let students = [new Student('kim', 95, 95, 100)];

students.push(new Student('lee', 90, 90, 100));
```

