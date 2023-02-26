<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석 -->
	<%-- JSP 주석: 컴파일 과정에서 없어짐 --%>
	<%
		// 스크립트릿 안에서는 JAVA 주석 가능	
	// 초기화하지 않으면 dummy data가 들어 있음(사용 불가)
	int i;
	i = 0;
	StringBuffer strBuf1 = new StringBuffer("soso");
	i++; j++;
	strBuf1.append("<span>👎</span>");
	strBuf2.append("<span>👍</span>");
	out.print("strBuf1= " + strBuf1 + "<br>");
	out.print("지역변수 i= " + i + "<br>");
	out.print("strBuf2= " + strBuf2 + "<br>");
	out.print("전역변수 j= " + j + "<br>");
	%>

	<%!// 선언부(전역변수, 메소드)
	// 초기화하지 않아도 수는 0으로, 문자열은 null로 자동초기화
	int j;
	StringBuffer strBuf2 = new StringBuffer("Good");

	private int sum(int a, int b) {
		return a + b;
	}%>
</body>
</html>