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
	<h2>세션의 특정 속성을 삭제</h2>
	<%
		// 세션삭제: 로그아웃 시 많이 사용
		session.removeAttribute("sessionNum"); // sessionNum 속성 삭제
		out.println("<p>sessionNum 삭제 후 모든 세션 list</p>");
		int cnt = 0;
		Enumeration<String> sAttrNames = session.getAttributeNames();
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
	
	<h2>모든 세션 삭제</h2>
	<%
		// setAttribute했던 모든 세션 속성 제거
		// 고유 세션 ID도 제거, 세션 추가 시 새로운 ID 발부
		session.invalidate();
		out.println("session.invalidate( ) 후");
		if(request.isRequestedSessionIdValid()){ // 유효한 세션 attribute가 있는지
		out.println("유효한 세션이 있습니다.");
		} else{
		out.println("유효한 세션이 없습니다.");
			
		}
	%>
	<hr>
	<a href = "ex01_sessionAddAttr.jsp">세션 속성 데이터 추가</a><br>
	<a href = "ex02_sessionGet.jsp">특정 세션 Get</a><br>
	<a href = "ex03_sessionList.jsp">모든 세션 리스트</a><br>
	<a href = "ex04_sessionRemove.jsp">세션 삭제(특정 세션 또는 모든 세션 데이터)</a><br>
</body>
</html>