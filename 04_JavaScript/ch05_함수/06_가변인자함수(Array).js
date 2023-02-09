// 가변인자함수: 매개변수의 갯수에 따라 변하는 함수
// 화살표함수에서는 불가
// 내장함수: Array()를 이용해서 가변인자 함수 array()를 생성

// 선언적함수
// function sum (x, y){
//     return x+y;
// }

// 익명함수
// var sum = function(){
//     return x+y;
// }

// 화살표함수
// var sum = (x, y)=> {
//     return x+y;
// }

var arr1 = [273, 2, 3, 'hello',];
var arr2 = Array(273, 2, 3, 'hello');
var arr3 = [ , , ,]; // 방 3개짜리 빈 배열
var arr4 = Array(3); // 방 3개짜리 빈 배열

console.log('arr1 = ', arr1, ' 방의 갯수 =', arr1.length);
console.log('arr2 = ', arr2, ' 방의 갯수 =', arr2.length);
console.log('arr3 = ', arr3, ' 방의 갯수 =', arr3.length);
console.log('arr4 = ', arr4, ' 방의 갯수 =', arr4.length);