<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	border-collapse: collapse;
}
th, td {
	padding: 5px;
}
</style>
</head>
<body>
 <c:if test="${boardDTO != null}">

	<table border = "1" frame="hsides" rules="rows">
		<tr>
				<td colspan="3">${boardDTO.subject}</td>
		</tr>
		<tr>

				<td width = "150" align="center">글번호${boardDTO.seq}</td>
				<td width = "150" align="center">작성자${boardDTO.id}</td>
				<td width = "150" align="center">조회수${boardDTO.hit}</td>
		</tr>
		<tr>
				<td colspan="3" height="250"><pre>${boardDTO.content}</pre></td>
		</tr>

	</table>
		<input type="button" value="목록" onclick="location.href='boardMVC/board/boardList.do?pg=${pg}'">	
 </c:if>
</body>
</html>