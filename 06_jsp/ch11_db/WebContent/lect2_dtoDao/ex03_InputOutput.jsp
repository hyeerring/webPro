<%@page import="java.sql.Date"%>
<%@page import="com.lec.dto.EmpDto"%>
<%@page import="com.lec.dao.EmpDao"%>
<%@page import="com.lec.dto.DeptDto"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"
%>
<%@page import="com.lec.dao.DeptDao"%>
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
<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="">
		<p>
			부서번호 <select name="deptno">
				<option value="0"></option>
				<%
					String deptnoStr = request.getParameter("deptno");
				if (deptnoStr == null) {
					deptnoStr = "0";
				}
				int deptnoInput = Integer.parseInt(deptnoStr); // 파라미터로 넘어 온 부서번호
				DeptDao deptdao = DeptDao.getInstance();
				ArrayList<DeptDto> deptList = deptdao.deptList();
				for (DeptDto dept : deptList) {
					int deptno = dept.getDeptno();
					String dname = dept.getDname();
					String loc = dept.getLoc();

					if (deptnoInput == deptno) {
						// <option value='10' selected='selected'>10-ACCOUNTING-NEW YORK</option>
						out.println("<option value='" + deptno + "' selected='selected'>(" + deptno + ")" + dname + "</option>");

					} else {
						out.println("<option value='" + deptno + "'>(" + deptno + ")" + dname + "</option>");
					}
				}
				%>
			</select>
			<input type="submit" value="검색">
		</p>
	</form>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>입사일</th>
			<th>부서번호</th>
		</tr>
		<%
		EmpDao empDao = EmpDao.getInstance();
		ArrayList<EmpDto> empList = empDao.deptnoEmpList(deptnoInput);
		if(!empList.isEmpty()){
			for(int i=0; i<empList.size(); i++){
				int empno = empList.get(i).getEmpno();
				String ename = empList.get(i).getEname();
				Date hiredate = empList.get(i).getHiredate();
				int deptno = empList.get(i).getDeptno();
				
				out.println("<tr><td>" + empno + "</td>");
				out.println("<td>" + ename + "</td>");
				out.println("<td>" + hiredate + "</td>");
				out.println("<td>" + deptno + "</td></tr>");
			}
		} else{
			out.println("<tr><td colspan='4'>해당 부서에 사원이 없습니다.</td></tr>");
		}
		%>
	</table>
</body>
</html>