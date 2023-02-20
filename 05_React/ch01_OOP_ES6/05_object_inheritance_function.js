var kim = {name: 'kim'};
// var lee = {age: 20};
// lee.__proto__ = hong;
var lee = Object.create(kim); // kim을 부모로하는 새로운 객체를 생성

console.log('kim.name: ', kim.name);
console.log('lee.name: ', lee.name);
debugger;
lee.age = 20;
lee.name = 'lee';
console.log('kim.name: ', kim.name);
console.log('lee.name: ', lee.name);