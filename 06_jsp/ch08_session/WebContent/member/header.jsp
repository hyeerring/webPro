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
			String name = (String) session.getAttribute("name");

			if (name == null) { // 로그인 전 header화면
			%>
			<ul>
				<li><a href="<%=conPath%>/member/join.jsp">회원가입</a></li>
				<li><a href="<%=conPath%>/member/login.jsp">로그인</a></li>
				<li><a href="<%=conPath%>/member/main.jsp">HOME</a></li>
			</ul>
			<%
				} else { // 로그인 후 header 화면
			%>
			<ul>
				<li><a href="<%=conPath%>/member/logout.jsp">로그아웃</a></li>
				<li><a href="<%=conPath%>/member/sessionAttrList.jsp">세션 들여다보기</a></li>
				<li><a href="<%=conPath%>/member/main.jsp"><%=name%>님 </a></li>
			</ul>

			<%
				}
			%>
			<hr>
		</div>
	</header>
</body>
</html>