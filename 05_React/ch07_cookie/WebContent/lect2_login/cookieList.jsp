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
	<h1>쿠키 리스트</h1>
	<%
		Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			String name = cookies[i].getName(); // i번째 cookie 이름
			String value = cookies[i].getValue();
			out.println(i + "번째 쿠키 이름: " + name + ", 값: " + value + "<br>");
		}
	} else {
		out.println("해당 서버로부터 생성된 쿠키가 없습니다.");
	}
	%>
	<hr>
	<button onclick="history.go(-1)">뒤로가기</button>
	<button onclick="location.href='welcome.jsp'">메인페이지</button>
</body>
</html>