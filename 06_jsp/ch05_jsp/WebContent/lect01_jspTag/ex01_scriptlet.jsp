<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 스크립트릿은 어디서든 사용 가능 --%>
<%
	String color = request.getParameter("color");
if (color == null) {
	color = "white";
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: <%=color%>;
}
</style>
</head>
<body>
	<h1>배경색 변경</h1>
	<form action="" method="get">
		<select name="color">
			<option value="red">빨강</option>
			<option value="orange">주황</option>
			<option value="yello">노랑</option>
			<option value="green">초록</option>
			<option value="blue">파랑</option>
			<option value="navy">남색</option>
			<option value="purple">보라</option>
		</select> <input type="submit" value="적용">
	</form>
</body>
</html>