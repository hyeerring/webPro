<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p{
	text-align: center;
}

p:last-child{
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<form action="">
		<p>
			<input type="text" name="su1" readonly="readonly"
				value="<%=(int)(Math.random()*9)+1 %>"> *
			<input type="text" name="su2"  readonly="readonly"
				value="<%=(int)(Math.random()*9)+1 %>"> =
			<input type="number" name="result">
		</p>
		<p>
			<input type="submit" value="확인">
		</p>
	</form>
	<p>
		${param.su1 } * ${param.su2 } = ${param.result}는 
		${param.result eq (param.su1 * param.su2) ? "true 정답" : "false 오답"}
	</p>
</body>
</html>