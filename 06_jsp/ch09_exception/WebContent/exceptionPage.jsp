<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- ex02.jsp에서 예외(500 Error)가 발생하면 연결되는 페이지 -->
<%@ page isErrorPage="true"%>
<%  response.setStatus(200);
		// 200 : 정상상태
		// 404 : 문서를 찾을 수 없을 때
		// 405 : 특별한 경우 자원을 허용 못 할 때
		// 407 : 인증이 필요한 경우
		// 500 : 문법 오류 또는 예외 발생
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
console.log('예외 타입 : <%=exception.getClass().getName()%>');
console.log('예외 메세지 : <%=exception.getMessage()%>');
	alert('0으로는 나눌 수 없습니다.');
	location.href = 'input.html';
</script>
</head>
<body>
	<h2>공사중입니다</h2>
</body>
</html>