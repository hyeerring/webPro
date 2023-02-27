<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 요청 url: ex01_forward.jsp?n=1 -->
	
	<h2>ex01_forward.jsp</h2>
	<!-- 주소창의 url이 그대로: request 객체가 그대로 유지 -->
	<jsp:forward page="ex02_forward.jsp"/>
	<%--
		// 주소창의 url이 변경: 새로운 요청(request 객체)
		response.sendRedirect("ex02_forward.jsp");
	--%>
</body>
</html>