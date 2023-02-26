<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.Reader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String conPath = request.getContextPath(); // "/ch05_jsp"		
		String appPath = application.getContextPath();
		String absolutePath = application.getRealPath("."); // . : 현재 프로젝트가 실행되는 절대 경로
	%>
	conPath: <%=conPath %><br>
	appPath: <%=appPath %><br>
	absolutePath: <%=absolutePath %><br>
	
	<%
		String filePath = application.getRealPath("WEB-INF/test.txt");
		out.println(filePath + "내용<br>");
		// 1. 스트림 객체 생성(기본스트림 --> 보조스트림)
		// 2. Read & Write
		// 3. 스트림 객체를 닫는다
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		while(true){
			String line = br.readLine();
			if(line == null)
				break;
			out.println(line+"<br>");
		}
		out.println("---- 파일 출력 끝 ----");
		br.close();
		/* Reader reader = null;
		BufferedReader br = null;
		try{
			reader = new FileReader(filePath); // 기본 스트림 생성
			br = new BufferedReader(reader); // 보조 스트림 생성(기본 스트림을 통해서 생성)
		
			while(true){
				String line = br.readLine();
				if(line == null){
					break;
				}
					out.println(line+"<br>");
			}
					out.println("---- 파일 출력 끝 ----");
		} catch(Exception e){
			out.println(e);
		} finally{
			try{
				if(br != null)
					br.close();
				if(reader != null)
					reader.close();
			} catch(Exception e){
			out.println(e);
			}
		} */
	%>
</body>
</html>