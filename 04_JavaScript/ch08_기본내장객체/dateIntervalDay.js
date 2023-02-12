// today.getIntervalDay(birth)
// today부터 birth까지 기간의 날짜를 return
// this = today. that = birth
console.log(new Date().getTime());

Date.prototype.getIntervalDay = function (that) {
    if (this>that) {
        var intervalMilliSec = this.getTime() - that.getTime();
    } else {
        var intervalMilliSec = that.getTime() - this.getTime();
    } // this ~ that 사이의 MilliSec
    var day = intervalMilliSec / (1000*60*60*24);
    return Math.trunc(day);
};

var today = new Date();
var birth = new Date(2023, 1, 2, 12, 0, 0); // 23년 생일: 23년 2월 2일
var nextbirth = new Date(2024, 1, 2, 12, 0, 0); // 24년 생일: 24년 2월 2일
console.log(today.getIntervalDay(birth) + '일 남았습니다.');
