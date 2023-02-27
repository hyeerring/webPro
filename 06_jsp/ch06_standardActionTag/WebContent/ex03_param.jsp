<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex_param.jsp?n=1 -->

	<h2>ex03_param.jsp</h2>
	<jsp:forward page="ex04_param.jsp">
		<jsp:param value="aaa" name="id"/>
		<jsp:param value="bbb" name="pw"/>
	</jsp:forward>
</body>
</html>