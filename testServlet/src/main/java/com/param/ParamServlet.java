package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/param")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//데이터
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
				//응답
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //생성
		out.println("<html>");
		out.println("<body>");
		out.println("나의 이름은 " + name + "이고, 내 나이는" + age + "살 이므로");
		if(age>=19) out.println("<font color = 'red'>성인</font> 입니다.");
		else out.println("<font color = 'red'>청소년</font> 입니다.");
		
		out.println("<br/><br/>");
//		out.println("<input type='button' value='뒤로' onclick='history.go(-1)'>");
		out.println("<input type='button' value='뒤로' onclick=location.href='http://localhost:8080/testServlet/param/param.html'>");
		
		out.println("</body>");
		out.println("</html>");
		
		
		/*
		 * 1. 콘솔 System.out.println("<html>");
		 * 
		 * 2. 파일 PrintWriter out = new PrintWriter(new FileWriter("result.txt"));
		 * out.println("<html>");
		 * 
		 * 3. 웹 PrintWriter out = response.getWriter();
		 * 
		 */		
		
		
	}

}
