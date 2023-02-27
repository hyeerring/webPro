<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex01_forward.jsp?n=1 요청시 연결 페이지 -->
	<h2>ex02_forward.jsp</h2>
	<%
		String n = request.getParameter("n");
	%>
	ex01에서 요청한 n: <%=n %>
</body>
</html>