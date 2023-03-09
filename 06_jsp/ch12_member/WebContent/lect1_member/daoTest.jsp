<%@page import="com.lec.member.MemberDto"%>
<%@page import="com.lec.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>MemberDao Test</h1>
	<%
		MemberDao dao = MemberDao.getInstance();
	// id 불일치
	String id = "AAA";
	int result = dao.confirmId(id);
	if (result == MemberDao.MEMBER_EXISTENT) {
		out.println("<p>1. confirmId 결과: " + id + "는 이미 등록된 id입니다. 회원가입 불가합니다.</p>");
	} else {
		out.println("<p>1. confirmId 결과: " + id + "등록 가능한 id입니다. 회원가입 가능합니다.</p>");
	}

	/* MemberDto dto = new MemberDto("BBB", "222", "김길동", "02", "1111", "2222", "M", "kim@google.com", null, "서울시 성동구", null);
	result = dao.joinMember(dto);
	if(result == MemberDao.SUCCESS){
		out.println("<p>2. join 결과: 회원가입 성공</p>");
	} else {
		out.println("<p>2. join 결과: 회원가입 실패</p>");
	} */

	out.println("<p>3. 로그인 결과(AAA, 111)</p>");
	result = dao.loginCheck("AAA", "111");
	if (result == MemberDao.LOGIN_SUCCESS) {
		out.println("<p>login 결과: 로그인 성공</p>");
	} else if (result == MemberDao.LOGIN_FAIL_PW) {
		out.println("<p>login 결과: pw 오류로 인한 로그인 실패</p>");
	} else if (result == MemberDao.LOGIN_FAIL_ID) {
		out.println("<p>login 결과: id 오류로 인한 로그인 실패</p>");
	}

	out.println("<p>3. 로그인 결과(AAA, 222)</p>");
	result = dao.loginCheck("AAA", "222");
	if (result == MemberDao.LOGIN_SUCCESS) {
		out.println("<p>login 결과: 로그인 성공</p>");
	} else if (result == MemberDao.LOGIN_FAIL_PW) {
		out.println("<p>login 결과: pw 오류로 인한 로그인 실패</p>");
	} else if (result == MemberDao.LOGIN_FAIL_ID) {
		out.println("<p>login 결과: id 오류로 인한 로그인 실패</p>");
	}

	out.println("<p>4. 아이디로 DTO 가져오기</p>");
	MemberDto dto = dao.getMember("AAA");
	out.println("<p>AAA : " + dto + "</p>");
	dto = dao.getMember("BBB");
	out.println("<p>BBB : " + dto + "</p>");

	out.println("<p>5. 정보수정</p>");
	dto = new MemberDto("BBB", "222", "김삼순", "02", "2222", "2222", "M", "kim@google.com", null, "서울시 성동구", null);
	result = dao.modifyMember(dto);
	if (result == MemberDao.SUCCESS) {
		out.println("수정 완료");
		out.println("수정된 데이터: dao.getMember(dto.getId()))");
	} else {
		out.println(dto.getId() + "수정 실패");
	}
	%>
</body>
</html>