<%@page import="java.util.Enumeration"%>
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
<link href="<%=conPath%>/css/style.css" rel="stylesheet"
	type="text/css"
>
</head>
<body>
	<%
		Enumeration<String> sessionNames = session.getAttributeNames();
	int cnt = 0;
	while (sessionNames.hasMoreElements()) {
		String attrName = sessionNames.nextElement();
		String attrValue = session.getAttribute(attrName).toString();
		out.println("<h3>세션명: " + attrName + " / 세션값: " + attrValue + "</h3>");
		cnt++;
	}
	if (cnt == 0) {
		out.println("<h3>유요한 세션이 없습니다.</h3>");
	
	}
	%>
	<button onclick="history.go(-1)'">이전페이지</button>
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='logout.jsp'">로그아웃</button>
	<button onclick="location.href='welcome.jsp'">메인페이지</button>
</body>
</html>