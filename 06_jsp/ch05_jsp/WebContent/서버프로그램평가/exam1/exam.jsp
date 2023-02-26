<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#wrap {
	text-align: center;
}

button {
	width: 100px;
	height: 60px;
	background-color: skyblue;
	margin: 10px;
}

h2 {
	color: red;
	font-weight: bold;
}
</style>
<script>
	function position(n) {
		location.href = 'examPro.jsp?su='+n;
		
	}
</script>
</head>
<body>
	<div id="wrap">
		<button onclick="position(1)">1번</button>
		<button onclick="position(2)">2번</button>
		<button onclick="position(3)">3번</button>
	<br>
	<%
	String msg = request.getParameter("msg");
	if(msg != null){
		out.println(msg);
	}
	%>
	</div>
</body>
</html>