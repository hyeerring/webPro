<%@page import="com.lec.member.MemberDao"%>
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
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page" />
	<jsp:setProperty property="*" name="dto" />
	<%
		String tempBirth = request.getParameter("tempBirth"); // " " or "1995-01-02"
	if (!tempBirth.equals("")) {
		dto.setBirth(Date.valueOf(tempBirth));
		// dto의 birth가 TimeStamp형일 경우: dto.setBirth(TimeStamp(valueOf(tempBirth+"00:00:00")))
	} // else 설정을 안해도 dto.setBirth(null);
	MemberDao mDao = MemberDao.getInstance();

	int result = mDao.confirmId(dto.getId()); // id 중복체크
	if (result == MemberDao.MEMBER_NONEXISTENT) {
		// 사용 가능한 id --> 회원가입 진행 
		result = mDao.joinMember(dto); // 회원가입
		if (result == MemberDao.SUCCESS) {
			// 회원가입 성공
			session.setAttribute("id", dto.getId()); // 회원가입 한 id를 세션에 저장
	%>
	<script type="text/javascript">
		alert('회원가입 되었습니다.');
		location.href = 'join.jsp';
	</script>
	<%
		} else {
	// 회원가입 실패
	%>
	<script type="text/javascript">
		alert('회원가입이 실패되었습니다. 확인이 필요합니다.');
		location.href = 'join.jsp'; // 작성한 데이터 제거된 상태로 돌아감
	</script>
	<%
		}
	} else { // 중복된 id --> join.jsp
	%>
	<script type="text/javascript">
		alert('중복된 id입니다. 다른 id를 사용하세요.');
		history.back(); // 작성한 데이터 그대로 돌아감
	</script>
	<%
		}
	%>
</body>
</html>