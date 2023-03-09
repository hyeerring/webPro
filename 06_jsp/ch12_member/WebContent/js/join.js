/**
 * 
 */
const infoConfirm = function() {
	var patternMail = /^[a-zA-Z0-9_\.]+@[a-zA-Z0-9_]+(\.\w+){1,2}$/;
	if (join_frm.id.value.length < 3) {
		alert('아이디는 3글자 이상이어야 합니다.');
		join_frm.id.focus();
		return;
	}
	if (!join_frm.pw.value) {
		alert('비밀번호는 필수 입력 사항입니다.');
		join_frm.pw.focus();
		return;
	}
	if (join_frm.pw.value != join_frm.pwChk.value) {
		alert('비밀번호가 일치하지 않습니다.');
		join_frm.pw = '';
		join_frm.pwChk = '';
		join_frm.pw.focus();
		return;
	}
	if (!join_frm.name.value) {
		alert('이름은 필수 입력 사항입니다.');
		join_frm.name.focus();
		return;
	}
	if (join_frm.email.value && !join_frm.email.value.match(patternMail)) {
		alert('이메일 형식을 확인하세요.');
		join_frm.email.focus();
		return;
	}
	join_frm.submit(); // 강제로 submit 이벤트 발생
};