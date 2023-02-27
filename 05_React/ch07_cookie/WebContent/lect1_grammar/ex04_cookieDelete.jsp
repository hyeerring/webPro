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
	<h2>특정 쿠키 삭제</h2>
	<%
	// 같은 이름의 쿠키를 생성하여 유효시간을 0초로 setting한 후 response 탑재
	// 0초짜리 같은 이름의 쿠키를 덮어 씌운다
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie c : cookies){
			String name = c.getName();
			if(name.equals("cookieName")){
				Cookie cookie = new Cookie("cookieName", "xxxxxx");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				out.println("쿠키 삭제 성공!");
				break;
			}
		}
	}
	%>
	<hr>
	<a href="ex01_cookieConstruct.jsp">쿠키 생성</a><br>
	<a href="ex02_cookieList.jsp">쿠키 리스트</a><br>
	<a href="ex03_thatCookie.jsp">특정 쿠키 확인</a><br> <!-- 쿠키이름: cookieName -->
	<a href="ex04_cookieDelete.jsp">특정 쿠키 삭제</a><br>
</body>
</html>