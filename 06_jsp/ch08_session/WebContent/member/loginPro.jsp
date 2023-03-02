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
<link href="<%=conPath%>/css/login.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	// DB에 id와 pw확인 작업
	
	
	if (id == null || !id.equals("aaa") || pw == null || !pw.equals("111")) {
		response.sendRedirect("login.jsp?msg=xx");
	} else{
		// 로그인 처리(세션)
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		session.setAttribute("name", "홍길동");
		response.sendRedirect(conPath + "/member/main.jsp");
	}
	%>
</body>
</html>