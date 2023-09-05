<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>    
<%@ page import="board.dao.BoardDAO" %>   
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
	<table border = "1" frame="hsides" rules="rows">
		<tr>
			<th>제목</th>
				<td><%=boardDTO.getSubject() %></td>
		</tr>
		<tr>
			<th width = "50">글번호</th>
				<td align="center"><%=boardDTO.getSeq() %></td>
			<th width = "150">작성자</th>
				<td align="center"><%=boardDTO.getId() %></td>
			<th width = "100">조회수</th>
				<td align="center"><%=boardDTO.getHit() %></td>
		</tr>
		<tr>
			<th>내용</th>
				<td align="center"><%=boardDTO.getContent() %></td>
		</tr>
		<tr>
		<th colspan="2" align="center">
				<input type="button" id="boardListBtn" value="목록">
			</th>
		</tr>
		
	</table>
</body>
</html>