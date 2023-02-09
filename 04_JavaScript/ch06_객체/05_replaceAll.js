// 00 --> ' ' 교체
// var str = '안녕하세요.00반갑습니다.00좋은하루00되세요.';
// console.log('원본 str :' + str);
// var splitStr = str.split('00'); // ['안녕하세요.', '반갑습니다.', '좋은하루', '되세요.']
// console.log('분할된 str' + splitStr);
// var joinStr = splitStr.join(' ');
// console.log('조인된 str' + joinStr); // 조인된 str안녕하세요. 반갑습니다. 좋은하루 되세요.

function replaceAll(str, oldStr, newStr) {
  // let splitStr = str.split(oldStr);
  // let result = splitStr.join(newStr);
  // return result;
  return str.split(oldStr).join(newStr);
}

// var replaceStr = replaceAll('안녕하세요.00반갑습니다.00좋은하루00되세요.', '00', ' ');
// console.log('결과 : ' + replaceStr);
