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
	<h2>ex06_param_include.jsp</h2>
	<hr>
	<jsp:include page="ex04_param.jsp">
		<jsp:param value="1" name="n"/>	
		<jsp:param value="aaa" name="id"/>	
		<jsp:param value="bbb" name="pw"/>	
	</jsp:include>
	<hr>
	<h2>다시 ex06_param_include.jsp</h2>
</body>
</html>