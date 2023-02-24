<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
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
	Date now1 = new Date();
	String str1 = String.format("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초", now1);
	GregorianCalendar now2 = new GregorianCalendar();
	SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일");
	String str2 = sdf.format(now2.getTime());
	%>
	<p>str: <%=str1 %></p>
	<p>str: <%=str2 %></p>
	<%@ include file="01_hello.jsp" %>
	
</body>
</html>