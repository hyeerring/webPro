<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 요청한 내용(/memberInsert) -->
	<%-- <h2>컨텍스트 path: <%=conPath %></h2> <!-- "/ch05_jsp" -->
	<h2>URI: <%=request.getRequestURI() %></h2> --%>
	<a href="<%=conPath%>/writer.do">회원가입</a>
	<button onclick="location.href='<%=conPath%>/delete.do'">회원탈퇴</button>
	<form action="<%=conPath%>/memberLogin.do">
		<input type="text" name="id" placeholder="ID를 입력하세요">
		<br>
		<input type="password" name="pw" placeholder="비밀번호를 입력하세요">
		<br>
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onclick="location.href='<%=conPath%>/join.do'">
		<!-- <button></button> : form태그 안의 button은 submit이 일어남-->
	</form>
</body>
</html>