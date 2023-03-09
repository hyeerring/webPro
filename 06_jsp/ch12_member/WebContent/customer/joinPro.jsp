<%@page import="com.lec.customer.CustomerDao"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.Timestamp"%>
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
<link href='<%=conPath%>/css/join.css' rel='stylesheet'>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.customer.CustomerDto" scope="page" />
	<jsp:setProperty property="*" name="dto" />

	<%
		String tempBirth = request.getParameter("tempBirth");
	if (!tempBirth.equals("")) {
		dto.setCbirth(Date.valueOf(tempBirth));
	}
	CustomerDao cDao = CustomerDao.getInstance();

	int result = cDao.confirmId(dto.getCid());
	if (result == CustomerDao.CUSTOMER_NONEXISTENT) {
		// 사용 가능한 id!
		result = cDao.joinCustomer(dto);
		if (result == CustomerDao.SUCCESS) {
			// 회원가입 성공!
			session.setAttribute("id", dto.getCid());
	%>
	<script type="text/javascript">
		alert('회원가입 감사합니다. 로그인 이후에 서비스를 이용하세요');
		location.href = 'login.jsp';
	</script>
	<%
		} else {
	// 회원가입 실패!
	%>
	<script type="text/javascript">
		alert('회원가입이 실패되었습니다. 너무 긴 데이터는 가입 불가합니다. 다시 가입해 주세요');
		location.href = 'join.jsp';
	</script>
	<%
		}
	} else {
	// 중복된 id!
	%>
	<script type="text/javascript">
		alert('등록된 id입니다. 다른 id를 사용하세요.');
		history.back();
	</script>
	<%
		}
	%>
	<jsp:include page="../customer/footer.jsp" />
</body>
</html>
