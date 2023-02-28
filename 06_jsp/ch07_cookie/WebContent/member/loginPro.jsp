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
	// DB에 id와 pw확인 작업
	
	
	if (id == null || !id.equals("test") || pw == null || !pw.equals("111")) {
		response.sendRedirect("login.jsp?msg=xx");
	} else{
		// 로그인 처리(쿠키 생성)
		Cookie cookie1 = new Cookie("id", id);
		cookie1.setMaxAge(-1);
		response.addCookie(cookie1); // id라는 이름의 쿠키를 response에 탑재

		Cookie cookie2 = new Cookie("name", "test"); // DB에서 가져온 이름을 구키값으로
		cookie2.setMaxAge(-1);
		response.addCookie(cookie2);
		response.sendRedirect(conPath + "/member/main.jsp");
	}
	%>
	<%-- <jsp:include page="../member/header.jsp" />
	<br>
	<br>

	<div id="loginForm_wrap">
		<div id="login_title">로그인 결과</div>
		<div id="login_join">로그인 성공</div>
	</div>
	<br>
	<br>
	<jsp:include page="footer.jsp" /> --%>
</body>
</html>