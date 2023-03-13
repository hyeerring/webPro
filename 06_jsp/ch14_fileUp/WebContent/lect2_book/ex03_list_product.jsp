<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.book.BookDao"%>
<%@page import="com.lec.book.BookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table>
		<tr>
		<%
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> books = bDao.listBook();
		for(int i = 0; i < books.size(); i++){
			int bPrice = books.get(i).getBprice();
			int bDiscount = books.get(i).getBdiscount();
			int discountPrice = bPrice * (100 - bDiscount) / 100;
			if(i != 0 && i % 3 == 0){
				out.println("</tr><tr>");		
			}
		%>
		<td>
			<a href="detail.jsp?bid=<%=books.get(i).getBid() %>">
				<img src="<%=conPath %>/bookImg/<%=books.get(i).getBimage1() %>"><br>
				<%=books.get(i).getBid() %>. <%=books.get(i).getBtitle() %><br>
			</a>
				<del><%=bPrice %></del><br>
				<b><%=discountPrice%>원</b>
		</td>
		<%
		} // for
		%>
		</tr>
	</table>
</body>
</html>