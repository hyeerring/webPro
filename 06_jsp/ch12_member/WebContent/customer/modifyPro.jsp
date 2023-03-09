<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="page" />
	<jsp:setProperty name="dto" property="*" />
	<%
		String tempBirth = request.getParameter("tempBirth");
	if (!tempBirth.equals("")) {
		dto.setCbirth(Date.valueOf(tempBirth));
	}
	CustomerDto customer = (CustomerDto) session.getAttribute("customer"); // 세션의 pw 필요
	String sessionPw = customer.getCpw();
	if (customer != null) {
		sessionPw = customer.getCpw();
	}
	String oldcpw = request.getParameter("oldcpw");
	String newcpw = request.getParameter("newcpw");
	if (sessionPw.equals(oldcpw)) {
		// 현 비밀번호를 맞게 입력한 경우
		if (dto.getCpw() == null) {
			// 새 비밀번호를 현 비밀번호로 수정
			dto.setCpw(newcpw);
		}
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.modifyCustomer(dto);
		if (result == CustomerDao.SUCCESS) {
			// 정보 수정 성공
			session.setAttribute("customer", dto); // 수정된 정보를 session 속성으로 수정
	%>
	<script type="text/javascript">
		alert('정보 수정이 완료되었습니다.');
		location.href = 'main.jsp';
	</script>
	<%
		} else {
	// 정보 수정 실패
	%>
	<script type="text/javascript">
		alert('회원정보 수정이 실패했습니다.');
		location.href = 'modify.jsp';
	</script>
	<%
		}
	} else {
	// 현 비밀번호를 틀리게 입력한 경우 --> modify.jsp
	%>
	<script type="text/javascript">
		alert('현 비밀번호가 맞지 않습니다. 다시 입력하세요.');
		history.back();
	</script>
	<%
		}
	%>
	<%=dto%>

</body>
</html>