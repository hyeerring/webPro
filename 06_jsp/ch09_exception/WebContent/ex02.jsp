<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<%@ page errorPage="exceptionPage.jsp"%><!-- web.xml의 예외페이지 처리보다 우선순위가 높음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	out.println("num1 = " + num1 + "<br>");
	out.println("num2 = " + num2 + "<br>");
	out.println("num1 + num2 = " + (num1 + num2) + "<br>");
	out.println("num1 - num2 = " + (num1 - num2) + "<br>");
	out.println("num1 * num2 = " + (num1 * num2) + "<br>");
	out.println("num1 / num2 = " + (num1 / num2) + "<br>");
	%>
	<script type="text/javascript">
		console.log("0으로 나눔");
	</script>
</body>
</html>