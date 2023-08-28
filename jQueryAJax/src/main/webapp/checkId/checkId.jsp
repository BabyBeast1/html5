<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML태그 시작전의 공백을 제거 --%>
<%
//DB 연동
//만약에 user_id가 "hong"이면 이미 DB에 저장된 아이디로 취급(true) - 사용X
//                                           false - 사용가능
String user_id = request.getParameter("user_id");

boolean result = false;
if(user_id.equals ("hong")) result = true;
%>

<%-- XML로 보내기 --%>
<?xml version="1.0" encoding="UTF-8"?>
<check_id>
	<result><%= result %></result>
</check_id>