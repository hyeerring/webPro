<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<h1>1_hello.jsp</h1>
	<%
	// jsp ���� java
	int total = 0;
	for (int cnt =0; cnt<=100; cnt++){
		total += cnt;
		}
	%>
	<h2>1���� 100���� ������ ��: <%=total%></h2>
</body>
</html>