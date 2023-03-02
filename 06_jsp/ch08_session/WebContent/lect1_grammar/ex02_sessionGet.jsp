<%@page import="com.lec.ex.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		// 특정한 세션값 가져오기(세션의 특정한 속성값 가져오기)
		String sessionName = (String)session.getAttribute("sessionName");
		int sessionNum = (Integer)session.getAttribute("sessionNum");
		Member member = (Member)session.getAttribute("member");
		// 세션에 추가하지 않은 데이터
		String noneSessionName = (String)session.getAttribute("noneSessionName");
		
		out.println("sessionName: " + sessionName +"<br>");
		out.println("sessionNum: " + sessionNum +"<br>");
		if(member != null){
			out.println("member id: " + member.getId() +"<br>");
			out.println("member name: " + member.getName() +"<br>");
			
		}
		out.println("noneSessionName(세션에 추가하지 않은 데이터): " + noneSessionName +"<br>");
	%>
	<hr>
	<a href = "ex01_sessionAddAttr.jsp">세션 속성 데이터 추가</a><br>
	<a href = "ex02_sessionGet.jsp">특정 세션 Get</a><br>
	<a href = "ex03_sessionList.jsp">모든 세션 리스트</a><br>
	<a href = "ex04_sessionRemove.jsp">세션 삭제(특정 세션 또는 모든 세션 데이터)</a><br>
</body>
</html>