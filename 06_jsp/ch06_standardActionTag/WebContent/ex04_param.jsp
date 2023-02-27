<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex03_param.jsp?id=aaa -->
	
	<h2>ex04_param.jsp</h2>
	ex03의 request에서 넘어온 n : <%=request.getParameter("n") %><br>
	ex03의 request에서 넘어온 id : <%=request.getParameter("id") %><br>
	ex03의 request에서 넘어온 pw : <%=request.getParameter("pw") %><br>
</body>
</html>