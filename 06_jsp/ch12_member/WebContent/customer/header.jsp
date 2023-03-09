<%@page import="com.lec.customer.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header {
	width: 1000px;
	margin: 0 auto;
}

header ul {
	overflow: hidden;
}

header ul li {
	padding: 10px 40px;
	list-style: none;
	float: right;
	list-style: none;
}

header ul li a {
	text-decoration: none;
	font-weight: bold;
	color: #D4A190;
}
</style>
</head>
<body>
	<header>
		<div id="nav">
			<%
			CustomerDto customer = (CustomerDto)session.getAttribute("customer");

			if (customer == null) { // 로그인 전 header화면
			%>
			<ul>
				<li><a href="<%=conPath%>/customer/join.jsp">회원가입</a></li>
				<li><a href="<%=conPath%>/customer/login.jsp">로그인</a></li>
				<li><a href="<%=conPath%>/customer/main.jsp">HOME</a></li>
			</ul>
			<%
				} else { // 로그인 후 header 화면
			%>
			<ul>
				<li><a href="<%=conPath%>/customer/logout.jsp">로그아웃</a></li>
				<li><a href="<%=conPath%>/customer/modify.jsp">정보수정</a></li>
				<li><a href="<%=conPath%>/customer/main.jsp"><%=customer.getCname()%>님 </a></li>
			</ul>

			<%
				}
			%>
			<hr>
		</div>
	</header>
</body>
</html>