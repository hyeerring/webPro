<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.sql.Date"%>
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
	<%!String cid, cpw, cname, ctel, cemail, caddress, cgender;
	Date cbirth;%>
	<%
		CustomerDto customer = (CustomerDto) session.getAttribute("customer");
	if (customer == null) {
		response.sendRedirect("login.jsp ? method = modify");
	} else {
		cid = customer.getCid();
		cpw = customer.getCpw();
		cname = customer.getCname();
		ctel = customer.getCtel();
		cemail = customer.getCemail();
		caddress = customer.getCaddress();
		cbirth = customer.getCbirth();
		cgender = customer.getCgender();
	}
	%>
	<jsp:include page="../customer/header.jsp" />
	<div id="joinForm_wrap">
		<div id="join_title">정보수정</div>
		<form action="modifyPro.jsp" method="post">
			<input type="hidden" name="hiddenParam" value="xx">
			<table>

				<tr>
					<th><label for="cid">아이디</label></th>
					<td>
						<input type="text" name="cid" id="cid" class="cid" value="<%=cid%>"
							readonly="readonly"
						>
					</td>
				</tr>
				<tr>
					<th><label for="cpw">현비밀번호</label></th>
					<td>
						<input type="password" name="oldcpw" id="cpw" class="cpw"
							required="required"
						>
					</td>
				</tr>
				<tr>
					<th><label for="cpwChk">새비밀번호확인</label></th>
					<td>
						<input type="password" name="newcpw" id="cpwChk" class="cpwChk">
					</td>
				</tr>
				<tr>
					<th><label for="cname">이름</label></th>
					<td>
						<input type="text" name="cname" id="cname" class="cname"
							value="<%=cname%>" readonly="readonly"
						>
					</td>
				</tr>
				<tr>
					<th><label for="ctel">전화</label></th>
					<td>
						<input type="text" name="ctel" id="ctel" class="ctel" value="<%=ctel%>">
					</td>
				</tr>

				<tr>
					<th><label for="cemail">이메일</label></th>
					<td>
						<input type="text" name="cemail" id="cemail" class="cemail"
							value="<%=cemail%>"
						>
					</td>
				</tr>
				<tr>
					<th><label for="caddress">주소</label></th>
					<td>
						<input type="text" name="caddress" id="caddress" class="caddress"
							value="<%=caddress%>"
						>
					</td>
				</tr>
				<tr>
					<th><label for="cbirth">생년월일</label></th>
					<td>
						<input type="date" name="tempBirth"
							value="<%if (cbirth != null)
	out.print(cbirth.toString());%>"
						>
					</td>
				</tr>

				<tr>
					<th>성별</th>
					<td>
						<%
							if ("M".equals(cgender)) {
						%>
						<input type="radio" name="gender" value="M" checked="checked">
						남성
						<input type="radio" name="gender" value="F">
						여성
						<%
							} else if ("F".equals(cgender)) {
						%>
						<input type="radio" name="gender" value="M">
						남성
						<input type="radio" name="gender" value="F" checked="checked">
						여성
						<%
							} else {
						%>
						<input type="radio" name="gender" value="M">
						남성
						<input type="radio" name="gender" value="F">
						여성
						<%
							}
						%>
					</td>
				</tr>
				<tr>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="정보수정" class="joinBtn_style">
						<input type="reset" value="취소" onclick="history.back()"
							class="joinBtn_style"
						>
						<input type="button" value="로그아웃" onclick="location.href='logout.jsp'"
							class="joinBtn_style"
						>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>