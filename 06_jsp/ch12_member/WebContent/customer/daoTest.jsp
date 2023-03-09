<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
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
	<h1>CustomerDao Test</h1>
	<%
		CustomerDao dao = CustomerDao.getInstance();
	// id 불일치
	String cid = "BBB";
	int result = dao.confirmId(cid);
	if (result == CustomerDao.CUSTOMER_EXISTENT) {
		out.println("<p>1. confirmId 결과: " + cid + "는 이미 등록된 id입니다. 회원가입 불가합니다.</p>");
	} else {
		out.println("<p>1. confirmId 결과: " + cid + "등록 가능한 id입니다. 회원가입 가능합니다.</p>");
	}

	CustomerDto dto = new CustomerDto("BBB", "222", "이길동", "010-2222-2222", "bbb@test.com", "서울시 성동구", null, "M");
	result = dao.joinCustomer(dto);
	if (result == CustomerDao.SUCCESS) {
		out.println("<p>2. join 결과: 회원가입 성공</p>");
	} else {
		out.println("<p>2. join 결과: 회원가입 실패</p>");
	}

	out.println("<p>3. 로그인 결과(AAA, 111)</p>");
	result = dao.loginCheck("AAA", "111");
	if (result == CustomerDao.LOGIN_SUCCESS) {
		out.println("<p>login 결과: 로그인 성공</p>");
	} else if (result == CustomerDao.LOGIN_FAIL) {
		out.println("<p>login 결과: 로그인 실패</p>");
	}

	/* out.println("<p>4. 아이디로 DTO 가져오기</p>");
	CustomerDto dto = dao.getCustomer("AAA");
	out.println("<p>AAA : " + dto + "</p>");
	dto = dao.getCustomer("BBB");
	out.println("<p>BBB : " + dto + "</p>"); */
	%>
</body>
</html>