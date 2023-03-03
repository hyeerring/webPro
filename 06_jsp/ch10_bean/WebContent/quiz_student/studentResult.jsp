<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="student" class="com.lec.ex.Student" scope="request" />
	<table>
		<caption>학생 정보</caption>
		<tr>
			<th>학번</th>
			<td>
				<jsp:getProperty property="id" name="student" />
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<jsp:getProperty property="name" name="student" />
			</td>
		</tr>
		<tr>
			<th>학년</th>
			<td>
				<jsp:getProperty property="grade" name="student" />
			</td>
		</tr>
		<tr>
			<th>반</th>
			<td>
				<jsp:getProperty property="clas" name="student" />
			</td>
		</tr>
		<tr>
			<th>점수</th>
			<td>
				<jsp:getProperty property="score" name="student" />
			</td>
		</tr>
	</table>
</body>
</html>