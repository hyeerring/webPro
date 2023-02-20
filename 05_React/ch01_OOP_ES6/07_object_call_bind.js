// .call()
var kim = {name: 'kim', first: 10, second: 20};
var lee = {name: 'kim', first: 30, second: 40};

first = 100;
second = 200;
function sum(prefix = '-->'){
    return prefix + (this.first + this.second);
};

console.log('외부 변수의 합' + sum()); // sum 내부의 this: window 객체
console.log('외부 변수의 합' + sum(' = '));
console.log('kim의 합', sum.call(kim)); // sum 내부의 this: hong
console.log('kim의 합', sum.call(kim, ' = ')); // lee는 this, '='는 prefix
console.log('lee의 합', sum.call(lee, ' = ')); // lee는 this, '='는 prefix

// .bind()
var kimSum_ = sum.bind(kim);

console.log('bind를 이용한 kim의 합',kimSum_());

// ++ 중요!
var kimSum = function sum(prefix = '-->'){
    return prefix + (this.first + this.second);
};
console.log('bind를 이용한 kimSum', kimSum());

var leeSum = sum.bind(shin, '-->'); // this에는 lee, prefix에 '-->'
console.log('bind를 이용한 leeSum', leeSum());