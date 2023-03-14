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
	<h1>표현식 태그 이용</h1>
	<p>산술연산자: 10 + 1 = <%=10 + 1 %></p>
	<p>산술연산자: 10 / 0.0 = <%=10 / 0.0 %></p> <!-- 0으로 나누면 에러 -->
	<p>관계연산자: 1 > 2 = <%=1 > 2 %></p>
	<p>관계연산자: 1 == 2 = <%= 1 == 2 %></p>
	<p>관계연산자: 1 != 2 = <%=1 != 2 %></p>
	<p>조건연산자: <%=(1 > 2) ? "1이 2보다 크다" : "1은 2보다 크지 않다" %>
	<P>논리연산자: (1>2) || (1<2) = <%=(1>2) || (1<2) %></P>
	<p>로그인여부: <%=session.getAttribute("customer") == null ? "로그아웃" : "로그인" %>
	<p>로그인여부: <%=session.getAttribute("customer") != null ? "로그인" : "로그아웃" %>
	<p>pageNum 파라미터 여부: <%=request.getParameter("pageNum") == null ? "pageNum 없음" : "pageNum 있음"%></p>
	<p>su 파라미터 값: <%=request.getParameter("su") %></p>
	
	<h1>EL 표기법 이용</h1>
	표현식 안에 쓸 수 있는 연산자는 다 사용 가능
	<p>산술연산자: 10 + 1= ${10 + 1 }</p>
	<p>산술연산자: 10 / 0= ${10 / 0.0 }</p>
	<p>관계연산자: 1 > 2 = ${1 > 2 }</p>
	<p>관계연산자: 1 == 2 = ${1 eq 2 }</p>
	<p>관계연산자: 1 != 2 = ${1 != 2 }</p>
	<p>조건연산자: ${(1 > 2) ? "1이 2보다 크다" : "1은 2보다 크지 않다" }</p>
	<P>논리연산자: (1>2) || (1<2) = ${(1>2) || (1<2) }</P>
	<%-- <p>로그인여부: ${sessionScope.customer }</p> : sessionScope 생략가능 --%>
	<p>로그인여부: ${customer eq null ? "로그아웃" : "로그인" }</p>
	<p>로그인여부: ${empty customer ? "로그아웃" : "로그인"}</p>
	<p>로그인여부: ${not empty customer ? "로그인" : "로그아웃" }</p>
	<p>pageNum 파라미터 여부: ${empty param.pageNum ? "pageNum 없음" : "pageNum 있음" }</p>
	<p>su 파라미터 값: ${param.su }</p> <!-- error 안남 -->
	<p>su 파라미터 값의 대문자 변경: ${param.su.toUpperCase() }</p> <!-- error 안남 -->
</body>
</html>