<%@page import="com.lec.book.BookDto"%>
<%@page import="com.lec.book.BookDao"%>
<%@page import="java.util.ArrayList"%>
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
	<%
		// ex02_list.jsp 또는 ex02_list.jsp?pageNum=2
	String pageNum = request.getParameter("pageNum");
	if (pageNum == null) {
		pageNum = "1";
	}
	int currentPage = Integer.parseInt(pageNum);
	final int PAGESIZE = 3, BLOCKSIZE = 3;
	int startRow = (currentPage - 1) * PAGESIZE + 1;
	int endRow   = startRow + PAGESIZE - 1 ;

	BookDao dao = BookDao.getInstance();
	ArrayList<BookDto> books = dao.listBook(startRow, endRow);
	%>
	<table>
		<caption>책 리스트</caption>
		<tr>
			<th>ID</th>
			<th>도서명</th>
			<th>표지</th>
			<th>가격</th>
			<th>할인율</th>
		</tr>
		<%
			if (books.isEmpty()) {
			out.println("<tr><td colspan='5'>등록된 책이 없습니다.</td></tr>");
		} else {
			for (BookDto book : books) {
				int price = book.getBprice();
				int bdiscount = book.getBdiscount();
				int discountPrice = price * (100 - bdiscount) / 100;
		%>
		<tr>
			<td><%=book.getBid()%></td>
			<td>
				<a href="detail.jsp=<%=book.getBid()%>"><%=book.getBtitle()%></a>
			</td>
			<td>
				<a href="detail.jsp=<%=book.getBid()%>"><img
					src="<%=conPath%>/bookImg/<%=book.getBimage1()%>" width="40"
				>
				</a>
			</td>
			<td>
				<del><%=price%></del> 
				<b><%=discountPrice%>원</b>
			</td>
			<td><%=book.getBdiscount()%>%</td>
		</tr>
		<%
			}
		}
		%>
	</table>
	<div class="paging">
	<%
		// paging
	int bookTotalCnt = dao.getBookTotalCnt();
	int pageCnt = (int)Math.ceil((double)bookTotalCnt/PAGESIZE);
	int startPage = ((currentPage-1) / BLOCKSIZE) * BLOCKSIZE + 1;
	int endPage = startPage + BLOCKSIZE - 1;
	if(endPage > pageCnt){
		endPage = pageCnt;
	}
	if(startPage > BLOCKSIZE){
	%>
		[<a href="ex02_list.jsp?pageNum=<%=startPage - 1 %>"> 이전 </a>]		
	<%
	}
	for(int i = startPage; i <= endPage; i++){
		if(i == currentPage){
			out.print("<b>" + i + "</b>");
		} else {
			out.print("<a href='ex02_list.jsp?pageNum=" + i +"'>" + i + "</a>");
		}
	}
	if(endPage < pageCnt){
	%>
		[<a href="ex02_list.jsp?pageNum=<%=endPage + 1 %>"> 다음 </a>]		
	<%
	}
	%>		
	</div>
</body>
</html>