class Person{
    constructor(name, first, second){ // 생성자 함수
        // 생성자 이름의 이름은 무조건 constructor
        this.name = name;
        this.first = first;
        this.second = second;
    }
    sum(){
    return this.first + this.second;
    }
} // class

// 상속
class PersonPlus extends Person{
    constructor(name, first, second, third){
        super(name, first, second); // 부모클래스 생성자 함수
        this.third = third;
    }
    sum(){
        return this.first + this.second + this.third;
    }
    avg(){
        return this.sum()/3;
    }
}

var kim = new PersonPlus('kim', 10, 20, 30);
var lee = new PersonPlus('lee', 30, 20, 30);

console.log(kim.name, ',', kim.first, ',', kim.second, ',', kim.third, ' sum:', kim.sum(), 'avg: ', kim.avg() );
console.log(lee.name, ',', lee.first, ',', lee.second, ',', lee.third, ' sum:', lee.sum(), 'avg: ', lee.avg() );

