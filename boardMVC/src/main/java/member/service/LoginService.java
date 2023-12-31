package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class LoginService implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//DB
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.login(id, pwd);
		//응답
		
		if(memberDTO == null) {
			return "/member/loginFail.jsp";
		}else {
			//세션
			HttpSession session = request.getSession(); //세션 생성
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			 
			 return "/member/loginOk.jsp";
		}
	}
	
}
