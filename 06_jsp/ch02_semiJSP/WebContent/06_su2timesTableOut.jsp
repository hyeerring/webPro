<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
table {
	margin: 10px auto;
}

td {
	padding: 5px 10px
}
</style>
</head>
<body>
	<%
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
	%>
	<table>
		<%
			for (int h = su1; h <= su2; h++) {
		%>
		<th><%=h%>단</th>
		<%
			}
		%>
		<tr>
			<%
				for (int i = 1; i < 10; i++) {
				for (int j = su1; j <= su2; j++) {
			%>
			<td><%=j + " x " + i + " = " + (j * i)%></td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>