<%@page import="java.util.Enumeration"%>
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
	<h2>모든 세션 속성들</h2>
	<%
		// 세션에 추가한 모든 데이터 list
		
		// 모든 세션 속성들
		Enumeration<String> sAttrNames = session.getAttributeNames();
		int cnt = 0;
		while(sAttrNames.hasMoreElements()){
			String sname = sAttrNames.nextElement();
			String svalue = session.getAttribute(sname).toString();
			out.println(" 세션 속성 이름: " + sname +  " 세션 값: " + svalue + "<br>");
			cnt++;
		}
		if(cnt == 0){
			out.println("세션 속성이 없습니다.");
		}
	%>
	<hr>
	<a href = "ex01_sessionAddAttr.jsp">세션 속성 데이터 추가</a><br>
	<a href = "ex02_sessionGet.jsp">특정 세션 Get</a><br>
	<a href = "ex03_sessionList.jsp">모든 세션 리스트</a><br>
	<a href = "ex04_sessionRemove.jsp">세션 삭제(특정 세션 또는 모든 세션 데이터)</a><br>
</body>
</html>