<%@page import="com.lec.friend.FriendDto"%>
<%@page import="com.lec.friend.FriendDao"%>
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
	<h2>1. 친구 추가</h2>
	<%--
	FriendDao dao = FriendDao.getInstance();
	FriendDto dto = new FriendDto(name, tel);
	String name = "삼길동";
	String tel = "010-3333-3333";
	int result = dao.joinFriend(dto);
	
	if (result == FriendDao.SUCCESS){
		out.println("<p>친구 추가 성공</p>");
	} else{
		out.println("<p>친구 추가 실패</p>");
	} // 친구추가 성공
	--%>
	
	
</body>
</html>