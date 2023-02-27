<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- jsp 파일 원본 그대로 include: error -->
	<%-- <%@ include file="includedPage.jsp" %> --%>
	
	<!-- jsp 파일의 결과 html을 include -->
	<jsp:include page="includedPage.jsp"/>
	<h2>ex05_include.jsp</h2>
</body>
</html>