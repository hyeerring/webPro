<%@page import="com.lec.book.BookDto"%>
<%@page import="com.lec.book.BookDao"%>
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
	<!--
		// 파라미터가 없을 경우 list.jsp로
	String bidStr = request.getParameter("bid");
	if (bidStr == null) {
		response.sendRedirect("ex04_list.jsp");
	}
	int bid = Integer.parseInt(bidStr);
	-->
	<%
		int bid = Integer.parseInt(request.getParameter("bid"));
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		BookDao bDao = BookDao.getInstance();
		BookDto book = bDao.getBook(bid);
		
		int bPrice = book.getBprice();
		int bDiscount = book.getBdiscount();
		int discountPrice = bPrice * (100 - bDiscount) / 100;
	%>
	<table>
		<tr>
			<td rowspan="4">
				<img src="<%=conPath %>/bookImg/<%=book.getBimage1() %>" width="100">
			</td>
			<td>
				<%=book.getBid() %>번 도서 상세보기
			</td>
		</tr>
		<tr>
			<td><%=book.getBtitle() %></td>
		</tr>
		<tr>
			<td>
				<del><%=bPrice %></del><br>
				<b><%=discountPrice %>원 (<%=bDiscount %>% 할인)</b>
			</td>
		</tr>
		<tr>
			<td>
				<button>구매하기</button>
				<button onclick="location.href='ex04_llist.jsp?pageNum=<%=pageNum %>'">책목록</button>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<pre><%=book.getBcontent() %></pre>
				<img alt="서브이미지" src="<%=conPath %>/bookImg/<%=book.getBimage2() %>"><br>
			</td>
		</tr>
	</table>
</body>
</html>