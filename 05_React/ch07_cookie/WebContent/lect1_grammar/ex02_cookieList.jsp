<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h2>쿠키 리스트</h2>
	<%
		Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			String name = cookies[i].getName(); // i번째 cookie 이름
			String value = cookies[i].getValue();
			out.println(i + "번째 쿠키 이름: " + name + ", 값: " + value + "<br>");
		}
	} else {
		out.println("해당 서버로부터 생성된 쿠키가 없습니다.");
	}
	%>
	<hr>
	<a href="ex01_cookieConstruct.jsp">쿠키 생성</a><br>
	<a href="ex02_cookieList.jsp">쿠키 리스트</a><br>
	<a href="ex03_thatCookie.jsp">특정 쿠키 확인</a><br> <!-- 쿠키이름: cookieName -->
	<a href="ex04_cookieDelete.jsp">특정 쿠키 삭제</a><br>
</body>
</html>