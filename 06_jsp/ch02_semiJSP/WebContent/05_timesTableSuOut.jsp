<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<% // http://localhost:8090/ch02_semiJSP/05_timesTableOut.jsp?su=6
		int su = Integer.parseInt(request.getParameter("su"));
	%>
	<h2><%=su %>단 구구단</h2>
	<table>
	<%
		for (int i = 1; i < 10; i++) {
	%>
	<tr>
		<td><%=su %>*<%=i%> = <%=su * i%></td>
		<td><%=su + " * " + i + " = " + (su *i)%></td>
	</tr>
	<%
		}
	%>
	</table>
</body>
</html>