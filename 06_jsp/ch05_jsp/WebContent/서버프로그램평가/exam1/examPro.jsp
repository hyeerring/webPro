<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#wrap {
	text-align: center;
}

h2 {
	color: red;
	font-weight: bold;
}

button {
	width: 100px;
	height: 40px;
	background-color: skyblue;
}
</style>
</head>
<body>
	<%!String suStr;
	int su;%>
	<%
		suStr = request.getParameter("su");
	if (suStr != null) {
		su = Integer.parseInt(suStr);
		int random = (int) Math.floor(Math.random() * 3 + 1);
		if (su != random) {
			String msg = "<h2>Wrong! Try Again!</h2>" + "<h2>정답은 " + random + "입니다.</h2>";
			msg = URLEncoder.encode(msg, "utf-8");
			response.sendRedirect("exam.jsp?msg=" + msg);
		} else {
	%>
	<div id="wrap">
		<h2>정답입니다!</h2>
		<p>
			동전이 있던 곳은
			<%=su%>입니다!
		</p>
		<button onclick="location.href='exam.jsp'">다시 도전</button>
	</div>
	<%
		}
	}
	%>
</body>
</html>