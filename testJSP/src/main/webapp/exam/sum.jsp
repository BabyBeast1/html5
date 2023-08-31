<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//데이터
int x = Integer.parseInt(request.getParameter("x"));
int y = Integer.parseInt(request.getParameter("y"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="mul.jsp">
<input type="text" name="x" value="<%=x %>">
<input type="text" name="y" value="<%=y %>">

<%=x %> + <%=y %> = <%=x+y %> <br><br>

<input type="button" value="곱 구하기-button" onclick="location.href='mul.jsp?x=<%=x %>&y=<%=y %>'">
<input type="submit" value="곱 구하기-submit" >

</form>
</body>
</html>











