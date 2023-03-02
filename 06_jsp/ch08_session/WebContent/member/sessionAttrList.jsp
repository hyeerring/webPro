<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#mainForm_wrap {
	height: 600px;
	font-size: 18px;
	text-align: center;
	width: 800px;
	margin: 0px auto;
	color: #D4A190;
}
</style>
</head>
<body>
	<jsp:include page="../member/header.jsp" />
	<div id="mainForm_wrap">
	<%
		Enumeration<String> sessionNames = session.getAttributeNames();
	int cnt = 0;
	while (sessionNames.hasMoreElements()) {
		String attrName = sessionNames.nextElement();
		String attrValue = session.getAttribute(attrName).toString();
		out.println("<h3>세션명: " + attrName + " / 세션값: " + attrValue + "</h3>");
		cnt++;
	}
	if (cnt == 0) {
		out.println("<h3>유요한 세션이 없습니다.</h3>");
	}
	%>
	</div>
	<jsp:include page="../member/footer.jsp" />
</body>
</html>