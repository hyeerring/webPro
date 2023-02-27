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
	<h2>특정 쿠키 확인</h2>
	<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		int i;
		for(i =0; i<cookies.length; i++){
			String name = cookies[i].getName();
			if(name.equals("cookieName")){
				String value = cookies[i].getValue();
				out.println("찾고자하는 쿠키 이름: " + name + ", 값: " + value);
				break;
			}
		}
		if(i == cookies.length){
		out.println("검색하신 쿠키가 없습니다.");
		}
	} else{
		out.println("해당 서버로부터 생성된 쿠키가 없습니다.");
	}
	%>
	<hr>
	<a href="ex01_cookieConstruct.jsp">쿠키 생성</a><br>
	<a href="ex02_cookieList.jsp">쿠키 리스트</a><br>
	<a href="ex03_thatCookie.jsp">특정 쿠키 확인</a><br> <!-- 쿠키이름: cookieName -->
	<a href="ex04_cookieDelete.jsp">특정 쿠키 삭제</a><br>
</body>
</html>