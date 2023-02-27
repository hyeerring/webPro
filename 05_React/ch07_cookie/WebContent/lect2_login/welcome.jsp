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
</head>
<body>
	<!-- 쿠키가 있을 경우 쿠키값을 저장할 용도 -->
	<%!String id, name;%>
	<%
		Cookie[] cs = request.getCookies();
	if (cs != null) {
		for (Cookie c : cs) {
			if (c.getName().equals("id")) {
		id = c.getValue();
			} else if (c.getName().equals("name")) {
		name = c.getValue();
			}
		} // 로그인 했다면 id("aaa"), name("siri")
			// 로그인 전이면 id(null), name(null)
	}
	if (id == null) {
		// 로그인 전
	%>
	<h1>Guest 어서오세요.<br>
	 로그인 후 이용할 수 있습니다.</h1>
	<p>
		<button onclick="location.href='login.html'">Login</button>
		<button onclick="location.href='cookieList.jsp'">Check Cookie</button>
	</p>
	<%
		} else {
	// 로그인 후
	%>
	<h1><%=name%>님 반갑습니다.
	</h1>
	<p>
		<button onclick="location.href='logout.html'">Logout</button>
		<button onclick="location.href='cookieList.jsp'">Check Cookie</button>
	</p>

	<%
		}
	%>
</body>
</html>