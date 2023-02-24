<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		long result = power(2, 3);
	%>
	<p>2의 3승은: <%=result %></p>
	<p>4의 5승은: <%=power(4, 5) %></p>
	
	<%-- <%!~%> 선언부 : 변수나 메소드를 선언. 가장 먼저 수행--%>
	<%!private long power(int a, int b) { // a의 b승을 return
		long result = 1;
		for (int i = 1; i <= b; i++) {
			result *= a;
		}
		return result;
	}%>
</body>
</html>