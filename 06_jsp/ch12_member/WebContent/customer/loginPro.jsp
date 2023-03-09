<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
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
<link href="<%=conPath%>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	String cid = request.getParameter("cid");
	String cpw = request.getParameter("cpw");
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.loginCheck(cid, cpw);

	if (result == CustomerDao.LOGIN_SUCCESS) {
		CustomerDto customer = cDao.getCustomer(cid);
		session.setAttribute("customer", customer);
		response.sendRedirect("main.jsp");
	} else if (result == CustomerDao.LOGIN_FAIL) {
		response.sendRedirect("login.jsp?msg=xx");
	}
	%>
</body>
</html>