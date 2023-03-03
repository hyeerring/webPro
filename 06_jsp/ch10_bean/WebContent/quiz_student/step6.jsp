<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="student" class="com.lec.ex.Student" scope="request" />
	<jsp:setProperty property="*" name="student"/>
	<jsp:forward page="studentResult.jsp"/>
</body>
</html>