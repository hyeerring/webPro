<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/ex05.css" rel="stylesheet">
</head>
<body>
	<%
		/* request.setCharacterEncoding("utf-8"); */
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if (id == null || !id.equals("aaa") || pw == null || !pw.equals("111")) {
		/* String msg = "Check the ID and PW"; */
		String msg = "아이디와 비밀번호를 확인하세요.";
		msg = URLEncoder.encode(msg, "utf-8");
		response.sendRedirect("ex05_loginFrm.jsp?msg=" + msg);
	}/*  else{
		out.println("<h2>Id:" + id + "<br>패스워드:" + pw +"</h2>");
	} */
	%>
	<h2>
	ID: <%=id %><br>
	PW: <%=pw %>
	</h2>
</body>
</html>