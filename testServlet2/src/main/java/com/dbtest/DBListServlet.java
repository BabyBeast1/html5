package com.dbtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.DBTestDTO;
import com.dao.DBTestDAO;

@WebServlet("/DBListServlet")
public class DBListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 - X
		//DB 
		
		DBTestDAO dBTestDAO = new DBTestDAO();
		List<DBTestDTO> list = dBTestDAO.select();
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if(list != null) {
			
			out.println("<table border='1'>");
			
		for(DBTestDTO dBTestDTO : list) {
			out.println("<tr>");
			out.println("<td width = '100' align='center'>" + dBTestDTO.getName() + "</td>");
			out.println("<td width = '50' align='center'>" + dBTestDTO.getAge() + "</td>");
			out.println("<td width = '100' align='center'>" + dBTestDTO.getHeight() + "</td>");
			out.println("<td width = '200' align='center'>" + dBTestDTO.getLogtime() + "</td>");
			out.println("</tr>");
		} // for
		
		out.println("<table>");
		out.println("<img src='/testServlet2/image/강지영.jpg' alt='강지영' width='100' height='100'" +
				    "onclick=location.href='/testServlet2/exam/input.html' style='cursor: pointer;'> ");
		
		} //if
		out.println("</body>");
		out.println("</html>");
	}

}
