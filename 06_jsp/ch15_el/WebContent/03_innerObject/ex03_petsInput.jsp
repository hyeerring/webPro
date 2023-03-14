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
	<form action="ex04_petsResult.jsp">
		ID <input type="text" name="id">
		<p>키우는 애완동물을 선택하세요</p>
		<input type="checkbox" name="pets" value="강아지">강아지
		<input type="checkbox" name="pets" value="고양이">고양이
		<input type="checkbox" name="pets" value="토끼">토끼
		<input type="checkbox" name="pets" value="앵무새">앵무새
		<br>
		<!-- <select name="pet" multiple="multiple">
			<option>강아지</option>
			<option>고양이</option>
			<option>토끼</option>
			<option>앵무새</option>
		</select> -->
		<input type="submit" value="확인">
	</form>
</body>
</html>