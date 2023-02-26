<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>ageInput.html(나이 입력)-->agePro.jsp(나이에 따른 분기)-->pass.jsp</h2>
	<%
	int age = Integer.parseInt(request.getParameter("age"));
	%>
	<h2><%=age %>살 고객님 주류 구매 가능합니다.</h2>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='ex04_ageInput.html'"></button>
</body>
</html>