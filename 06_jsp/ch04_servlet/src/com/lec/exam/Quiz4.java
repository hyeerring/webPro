package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz4
 */
@WebServlet("/Quiz4")
public class Quiz4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Quiz4() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] color = { "red", "orange", "yellow", "green", "blue", "navy", "purple" };
		int i = Integer.parseInt(request.getParameter("color"));
		int j;
		if(i == 0) {
			j = color.length-1;
		}else {
			j = i-1;
		}
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<style>");
		out.println("body{background-color: " + color[i] + ";}");
		out.println("body{color: " + color[j] + ";}");
		out.println("</style>");
		out.println("<body>");
		out.println("<h2>GET방식 요청입니다.</h2>");
		out.println("<h2>글자색은 " + color[j] + " 배경색은 " + color[i] + "입니다</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] color = { "red", "orange", "yellow", "green", "blue", "navy", "purple" };
		int i = Integer.parseInt(request.getParameter("color"));
		int j;
		if(i == 0) {
			j = color.length-1;
		}else {
			j = i-1;
		}
		response.setContentType("text/html; charset = utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<style>");
		out.println("body{background-color: " + color[i] + ";}");
		out.println("body{color: " + color[j] + ";}");
		out.println("</style>");
		out.println("<body>");
		out.println("<h2>POST방식 요청입니다.</h2>");
		out.println("<h2>글자색은 " + color[j] + " 배경색은 " + color[i] + "입니다</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
//		doGet(request, response);
	}

}
