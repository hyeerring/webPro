<%@page import="com.lec.dao.BoardDao"%>
<%@page import="java.sql.Timestamp"%>
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
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.dto.BoardDto" scope="page" />
	<jsp:setProperty property="*" name="dto" />
	<%
		dto.setIp(request.getRemoteAddr()); // 클라이언트가 요청한 컴퓨터 ip
	/* dto.setRdate(new Timestamp(System.currentTimeMillis())); */ // 요청이 들어온 시점
	BoardDao bDao = BoardDao.getInstance();
	int result = bDao.insertBoard(dto);
	if (result == BoardDao.SUCCESS) {
	%>
	<script type="text/javascript">
	alert('글쓰기 성공');
		location.href = "<%=conPath%>/board/list.jsp";
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert('글쓰기 실패');
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>