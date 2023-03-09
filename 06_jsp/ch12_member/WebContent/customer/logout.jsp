<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#mainForm_wrap {
	height: 600px;
	line-height: 600px;
	font-size: 18px;
	text-align: center;
	width: 800px;
	margin: 0px auto;
	color: #D4A190;
	font-weight: bold;
}
</style>
</head>
<script type="text/javascript">
	setTimeout(function() {
		location.href="<%=conPath%>/customer/main.jsp";
	}, 3000);
</script>
<body>
	<%
		session.invalidate();
	%>
	<jsp:include page="../customer/header.jsp" />
	<div id="mainForm_wrap">
		<h2>로그아웃되었습니다. 잠시 후 페이지 이동이 있겠습니다.</h2>
	</div>

	<jsp:include page="../customer/footer.jsp" />
</body>
</html>