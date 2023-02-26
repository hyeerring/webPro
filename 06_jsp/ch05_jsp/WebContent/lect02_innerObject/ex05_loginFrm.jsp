<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/ex05.css" rel="stylesheet">
</head>
<body>
	<form action="ex05_loginCertification.jsp" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
	<div id="msg">
	<%
	String msg = request.getParameter("msg");
	if(msg != null){
		out.println(msg);
	}
	%>
	</div>
</body>
</html>