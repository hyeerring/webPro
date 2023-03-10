<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
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
	<%
		String num = request.getParameter("num");
		BoardDao bDao = BoardDao.getInstance();
		BoardDto dto = bDao.getBoardOneLine(num);
	%>
	<form action="<%=conPath %>/board/updatePro.jsp" method="post">
	<input type="hidden" name="num" value="<%=num %>">
		<table>
			<caption><%=num %>번 글 수정</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" readonly="readonly" value="<%=dto.getWriter() %>"></td>
			</tr>
			<tr>
				<th>제  목</th>
				<td><input type="text" name="subject" value="<%=dto.getSubject() %>" required="required"></td>
			</tr>
			<tr>
				<th>본  문</th>
				<td>
					<textarea name="content" rows="5" required="required"><%=dto.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" value="<%
					String email = dto.getEmail();
					out.print(email == null ? ' ' : email); 
				%>"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" class="btn">
					<input type="button" value="취소" onclick="histoty.go(-1)" class="btn">
					<input type="button" value="목록보기" onclick="location.href='<%=conPath %>/board/list.jsp'" class="btn">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>