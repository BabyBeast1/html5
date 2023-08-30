package com.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//데이터
		
		int intX = Integer.parseInt(request.getParameter("intX"));
		int intY = Integer.parseInt(request.getParameter("intY"));
				//응답
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //생성
		out.println("<html>");
		out.println("<body>");
		out.println("X + Y = " + (intX + intY) + "<br>");
		out.println("X - Y = " + (intX - intY) + "<br>");
		out.println("X * Y = " + (intX * intY) + "<br>");
		out.println("X / Y = " + (intX / intY));
		out.println("</body>");
		out.println("</html>");
		
		

		
	}

}
