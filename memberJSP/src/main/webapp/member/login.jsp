<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="member.dto.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>
<%
//데이터

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

//DB
MemberDAO memberDAO = new MemberDAO();
MemberDTO memberDTO = memberDAO.login(id, pwd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login.jsp">
<%if(memberDTO == null) { 
	response.sendRedirect("loginFail.jsp");	
}else{ 
//	response.sendRedirect("loginOk.jsp?name=" +URLEncoder.encode(name, "UTF-8"));	

//쿠키
/*
Cookie cookie = new Cookie("memName", name);
cookie.setMaxAge(30*60); //초 단위 -30분
response.addCookie(cookie);//클라이언트에 저장
Cookie cookie2 = new Cookie("memId", id);
cookie2.setMaxAge(30*60); //초 단위 -30분
response.addCookie(cookie2);
*/
//세션
// HttpSession session = request.getSession(); //세션 생성
 session.setAttribute("memName", memberDTO.getName());
 session.setAttribute("memId", id);
 session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
 
response.sendRedirect("loginOk.jsp");
} %>
</form>
</body>
</html>