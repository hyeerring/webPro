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
	<p>2�� 3����: <%=result %></p>
	<p>4�� 5����: <%=power(4, 5) %></p>
	
	<%-- <%!~%> ����� : ������ �޼ҵ带 ����. ���� ���� ����--%>
	<%!private long power(int a, int b) { // a�� b���� return
		long result = 1;
		for (int i = 1; i <= b; i++) {
			result *= a;
		}
		return result;
	}%>
</body>
</html>