<%@page import="com.lec.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
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
		MemberDto member = (MemberDto) session.getAttribute("member");
	if (member != null) { // 로그인
	%>
	<h2>
		<%=member.getName()%>님 어서오세요
	</h2>
	<p>
		<button onclick=location.href='modify.jsp'>정보수정</button>
		<button onclick=location.href='logout.jsp'>로그아웃</button>
	</p>
	<%
		} else { // 비로그인
	%>
	<h2>손님 어서오세요</h2>
	<p>
		<button onclick=location.href='join.jsp'>회원가입</button>
		<button onclick=location.href='login.jsp'>로그인</button>
	</p>
	<%
		}
	%>
</body>
</html>