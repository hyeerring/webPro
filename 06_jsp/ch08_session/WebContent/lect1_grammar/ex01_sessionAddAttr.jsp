<%@page import="com.lec.ex.Member"%>
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
<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		Member member = new Member("aaa", "111", "kim");

	// 세션에 데이터를 저장 = 세션에 속성을 추가
	session.setAttribute("sessionName", "sessionValue");
	session.setAttribute("sessionNum", 1);
	// => session.setAttribute("sessionNum", new Integer(1));
	session.setAttribute("member", member);

	// jsp파일에서는 session이 내장객체라서 바로 사용 가능
	// java에서는 session을 사용하려면 아래와 같이 사용
	HttpSession session2 = request.getSession();
	%>
	
	session 고유 ID: <%=session.getId() %><br>
	session 유효 시간: <%=session.getMaxInactiveInterval() %>초<br>
	<hr>
	sessionName 속성값: <%=session.getAttribute("sessionName") %><br>
	sessionNum 속성값: <%=session.getAttribute("sessionNum") %><br>
	member 속성값: <%=session.getAttribute("member") %><br>
	<hr>
	<a href = "ex01_sessionAddAttr.jsp">세션 속성 데이터 추가</a><br>
	<a href = "ex02_sessionGet.jsp">특정 세션 Get</a><br>
	<a href = "ex03_sessionList.jsp">모든 세션 리스트</a><br>
	<a href = "ex04_sessionRemove.jsp">세션 삭제(특정 세션 또는 모든 세션 데이터)</a><br>
	
	
</body>
</html>