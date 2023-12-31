<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.dto.MemberDTO"%>
<%@ page import = "member.dao.MemberDAO"%>
<%
//데이터
request.setCharacterEncoding("UTF-8"); // 한글처리 (post 방식일 경우만 필요, get 방식일 때는 안해도됨)

String name = request.getParameter("name");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String gender = request.getParameter("gender");
String email1 = request.getParameter("email1");
String email2 = request.getParameter("email2");
String tel1 = request.getParameter("tel1");
String tel2 = request.getParameter("tel2");
String tel3 = request.getParameter("tel3");
String zipcode = request.getParameter("zipcode");
String addr1 = request.getParameter("addr1");
String addr2 = request.getParameter("addr2");

MemberDTO memberDTO = new MemberDTO();

memberDTO.setName(name);
memberDTO.setId(id);
memberDTO.setPwd(pwd);
memberDTO.setGender(gender);
memberDTO.setEmail1(email1);
memberDTO.setEmail2(email2);
memberDTO.setTel1(tel1);
memberDTO.setTel2(tel2);
memberDTO.setTel3(tel3);
memberDTO.setZipcode(zipcode);
memberDTO.setAddr1(addr1);
memberDTO.setAddr2(addr2);

//DB
MemberDAO memberDAO = new MemberDAO();
memberDAO.write(memberDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 가입이 되었습니다.</h3>
<input type="button" value="로그인" onclick="location.href='loginForm.jsp'">
</body>
</html>