<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
	Cookie cookie = new Cookie("cookieName","cookieValue"); // 쿠키생성
	cookie.setMaxAge(60*60); // 1시간 유효한 쿠키
	response.addCookie(cookie); // response에 탑재
	%>
	<h2>생성된 쿠키 이름: <%=cookie.getName() %></h2>
	<h2>생성된 쿠키의 값: <%=cookie.getValue() %></h2>
	<hr>
	<a href="ex01_cookieConstruct.jsp">쿠키 생성</a><br>
	<a href="ex02_cookieList.jsp">쿠키 리스트</a><br>
	<a href="ex03_thatCookie.jsp">특정 쿠키 확인</a><br> <!-- 쿠키이름: cookieName -->
	<a href="ex04_cookieDelete.jsp">특정 쿠키 삭제</a><br>
</body>
</html>