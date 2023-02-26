package com.lec.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MVC 패턴에서 컨트롤러 역할을 하는 Servlet
 */
@WebServlet("*.do")
public class Ex3_mvc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3_mvc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청된 command(writer.do, join.do, memberLogin.do, delete.do)
		// uri: /ch05_jsp/join.do
		// conPath: /ch05_jsp
		response.setContentType("utf-8");
		String conPath = request.getContextPath();
		String uri = request.getRequestURI();
		String command = uri.substring(conPath.length()+1);
		
		System.out.println(conPath);
		System.out.println(uri);
		System.out.println(command);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
