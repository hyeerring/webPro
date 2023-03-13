<%@page import="com.lec.book.*"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		// 책 등록 Pro
	String path = request.getRealPath("bookImg");
	int maxSize = 1024 * 1024 * 3; // 최대 용량 사이즈: 3MB
	String[] images = new String[2];
	MultipartRequest mRequest = null;
	
	try{
		mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy()); 
		Enumeration<String> paramNames = mRequest.getFileNames();
		int idx = 0;
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement();
			images[idx] = mRequest.getFilesystemName(param);
			System.out.println(idx + "번째 처리한 파라미터: " + param + " / 파일이름: " + images[idx]);
			idx ++;
		}
	} catch(IOException e){
		System.out.println(e.getMessage());
	}
	
	// 서버로 올려진 파일을 소스 폴더로 복사
	for(String imgfile : images){
		InputStream is = null;
		OutputStream os = null;
		File serverFile = new File(path + "/" + imgfile);
		if(serverFile.exists()){
			try{
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/programming/06_jsp/ch14_fileUp/WebContent/bookImg/" + imgfile);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true){
					int readByteCnt = is.read(bs);
					if(readByteCnt == -1)
						break;
					os.write(bs, 0, readByteCnt);
				}
			} catch(IOException e){
				System.out.println(e.getMessage());		
			} finally {
				try{
					if(os != null)
						os.close();
					if(is != null)
						is.close();
				} catch(Exception e){
					System.out.println(e.getMessage());	
				}
			} // try-catch
		} // if
	} // for
	
	String btitle = mRequest.getParameter("btitle");
	int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
	String bimage1 = images[1] != null ? images[1] : "noImg.png";
	String bimage2 = images[0] != null ? images[0] : "NOTHING.JPG";
	String bcontent = mRequest.getParameter("bcontent");
	int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
	// ip가 필요한 경우는 request 이용
	// String ip = request.getRemoteAddr();
	BookDto dto = new BookDto(0, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, null);
	BookDao bDao = BookDao.getInstance();
	int result = bDao.insertBook(dto);
					
	if(result == BookDao.SUCCESS){
		out.println("<h2>등록 성공</h2>");
	} else{
		out.println("<h2>등록 실패</h2>");
	}
	%>
	<hr>
	<h2>책이름: <%=btitle %></h2>
	<h2>
		가격: <del><%=bprice%></del> <b><%=bprice * (100-bdiscount) / 100%>원(<%=bdiscount %>% 할인)</b>
	</h2>
	<h2>
		대표이미지: <%=path %>/<%=bimage1 %>
		<img alt="대표이미지" src="<%=conPath %>/bookImg/<%=bimage1 %>">
	</h2>
	<h2>
		서브이미지: <%=path %>/<%=bimage2 %>
		<img alt="대표이미지" src="<%=conPath %>/bookImg/<%=bimage2 %>">
	</h2>
	<h2>설명:</h2>
	<pre><%=bcontent %></pre>
	
	<hr>
	<a href="ex01_list_board.jsp">책 전체 리스트(게시판 스타일)</a><br>
	<a href="ex02_list.jsp">1페이지 리스트(게시판 스타일)</a><br>
	<a href="ex03_list_product.jsp">책 전체 리스트(product list 스타일)</a><br>
	<a href="ex04_list.jsp">1페이지 리스트(product list 스타일)</a><br>
</body>
</html>