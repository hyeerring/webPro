<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>6단 구구단</h2>
<table>
	<%
		for (int i = 1; i < 10; i++) {
	%>
	<tr>
		<td>6*<%=i%> = <%=6 * i%></td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>