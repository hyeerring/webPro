/* 2.js :동적인 부분 */
name = prompt("이름을 입력하세요", "Siri"); // 취소를 클릭하면 'null' 리턴
if (name != 'null' && name != '') {
    document.write(name + "님 안녕하세요!<br>");
}