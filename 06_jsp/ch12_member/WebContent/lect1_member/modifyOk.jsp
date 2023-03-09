<%@page import="com.lec.member.MemberDao"%>
<%@page import="com.lec.member.MemberDto"%>
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
	<%-- modify.jsp에서 전달받은 파라미터: id, pw(변경할 pw), name, phone1, 2, 3, gender, email, address (MemberDto) 
		dto에 없는 파라미터 변수: oldPw(변경 전 pw), tempBirth --%>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page" />
	<jsp:setProperty name="dto" property="*" />
	<%
		String tempBirth = request.getParameter("tempBirth");
	if (!tempBirth.equals("")) {
		dto.setBirth(Date.valueOf(tempBirth));
	}
	MemberDto member = (MemberDto) session.getAttribute("member"); // 세션의 pw 필요
	String sessionPw = member.getPw();
	if (member != null) {
		sessionPw = member.getPw(); // 세션 member의 pw
	}
	String oldPw = request.getParameter("oldPw");
	if (sessionPw.equals(oldPw)) {
		// 현 비밀번호를 맞게 입력한 경우
		if (dto.getPw() == null) {
			// 새 비밀번호를 현 비밀번호로 수정
			dto.setPw(oldPw);
		}
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.modifyMember(dto);
		if (result == MemberDao.SUCCESS) {
			// 정보 수정 성공
			session.setAttribute("member", dto); // 수정된 정보를 session 속성으로 수정
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