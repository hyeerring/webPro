<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
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
	padding: 10px 40px; list-style : none;
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
				String id = null; // id 쿠키가 있을 경우 쿠키값을 저장하는 용도
			Cookie[] cs = request.getCookies();
			if (cs != null) {
				for (Cookie c : cs) {
					if (c.getName().equals("id")) {
				id = c.getValue();
				break;
					}
				}
			} // if
			if (id == null) {
				// 로그인 전 header화면
			%>
			<ul>
				<li><a href="<%=conPath%>/member/join.jsp">회원가입</a></li>
				<li><a href="<%=conPath%>/member/login.jsp">로그인</a></li>
				<li><a href="<%=conPath%>/index.jsp">HOME</a></li>
			</ul>
			<%
				} else {
			// 로그인 후 header 화면
			%>
			<ul>
				<li><a href="<%=conPath%>/member/logout.jsp">로그아웃</a></li>
				<li><a href="<%=conPath%>/member/cookieList.jsp">Cookie List</a></li>
				<li><a href="<%=conPath%>/member/main.jsp"><%=id %>님 반갑습니다</a></li>
			</ul>

			<%
				}
			%>
			<hr>
		</div>
	</header>
</body>
</html>