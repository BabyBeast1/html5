<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.dao.MemberDAO"%>
    
<%
//데이터

String id = request.getParameter("id");

//DB
MemberDAO memberDAO = new MemberDAO();
boolean exist = memberDAO.isExistId(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="checkId.jsp">
<%if(exist){ %>
	<h3><%=id %>는 이미 사용 중입니다.</h3>
	아이디 <input type="text" name="id">
	<input type="submit" value="중복체크">
	
<%}else{ %>
	<h3><%=id %>는 사용 가능합니다.</h3>
	<input type="button" value="사용하기" onclick="checkIdClose('<%=id %>')">
<%} %>
</form>

<script type="text/javascript">
function checkIdClose(id){
	opener.document.getElementById("id").value = id;
	opener.document.getElementById("sw").value = id;
	window.close();
	opener.document.getElementById("pwd").focus();
}
</script>
</body>
</html>










