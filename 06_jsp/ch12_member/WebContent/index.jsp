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
	<!-- url 그대로 -->
	<%-- <jsp:forward page="lect1_member/main.jsp"></jsp:forward> --%>
	<%
	response.sendRedirect("lect2_memberConn/main.jsp");
	%>
</body>
</html>