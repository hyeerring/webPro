<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 지시자: page(import시 많이 사용), include, taglib  --%>
	<%
		int[] arr = { 10, 20, 30 };
	out.println(Arrays.toString(arr));
	%>
	<hr>
	<%-- 모든 페이지에 동일하게 적용하는 footer --%>
	<%@include file="../main/footer.jsp"%>
	<hr>
	다시 ex03_지시자.jsp 페이지
</body>
</html>