<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="p" class="com.lec.ex.Person" scope="request"/>
	<jsp:setProperty name="p" property="*"/>
	<jsp:forward page="personView.jsp"/>
</body>
</html>