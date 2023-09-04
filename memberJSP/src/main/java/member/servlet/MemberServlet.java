package member.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

@WebServlet("/Member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String gender = request.getParameter("gender");
        String email1 = request.getParameter("email1");
        String email2 = request.getParameter("email2");
        String email3 = request.getParameter("email3");
        String tel1 = request.getParameter("tel1");
        String tel2 = request.getParameter("tel2");
        String tel3 = request.getParameter("tel3");
        String zipcode = request.getParameter("zipcode");
        String addr1 = request.getParameter("addr1");
        String addr2 = request.getParameter("addr2");
        
        // MemberDTO 객체에 회원 정보 저장
        MemberDTO member = new MemberDTO();
        member.setName(name);
        member.setId(id);
        member.setPwd(pwd);
        member.setGender(gender);
        member.setEmail1(email1);
        member.setEmail2(email2);
        member.setTel1(tel1);
        member.setTel2(tel2);
        member.setTel3(tel3);
        member.setZipcode(zipcode);
        member.setAddr1(addr1);
        member.setAddr2(addr2);
        
        // MemberDAO를 사용하여 회원 정보를 데이터베이스에 저장
        MemberDAO memberDAO = new MemberDAO();
       
    }

	}

