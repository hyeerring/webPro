// ES6에서는 class끼리 뿐 아니라 객체끼지도 상속 관계를 맺을 수 있다.
var superObj = {superVal : 'super value'};
var subObj = {subVal : 'sub value'};

subObj.__proto__ = superObj;  // 표준으로 인정받지는 못한 방법
console.log(subObj.superVal);
debugger; // 일시 중지하면서 객체 상태를 모니터링
subObj.subVal = 'subObj 수정';
console.log('수정 후 superObj.superVal: ' + superObj.superVal);
console.log('수정 후 subObj.superVal: ' + subObj.superVal);