package guestbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;


@WebServlet("/GuestbookWriteServlet")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		guestbookDTO.setName(name);
		guestbookDTO.setEmail(email);
		guestbookDTO.setWebsite(website);
		guestbookDTO.setTitle(title);
		guestbookDTO.setContent(content);
		
		//DB
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		guestbookDAO.write(guestbookDTO);
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>작성하신 글 등록 완료</h3>");
		out.println("<br/><br/>");
		out.println("<input type= 'button' value='목록' onclick=location.href='/guestbookServlet/GuestbookListServlet?pg=1'> ");
		out.println("</body>");
		out.println("</html>");
		
	}

}
