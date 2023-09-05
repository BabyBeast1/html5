<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>    
<%@ page import="board.dao.BoardDAO" %>    
<%@ page import="java.text.SimpleDateFormat" %>    
<%@ page import="java.util.List" %>    
<%
//데이터
int pg = Integer.parseInt(request.getParameter("pg"));

//1페이지당 5개씩 설정
int endNum = pg *5; 
int startNum = endNum -4;
//DB
BoardDAO boardDAO = new BoardDAO();
List<BoardDTO> list = boardDAO.getBoardList(startNum, endNum);


%>
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
<% if(list != null){ %>
	<table border = "1" frame="hsides" rules="rows">
		<tr>
			<th width="100">글번호</th>
			<th width="400">제목</th>
			<th width="150">작성자</th>
			<th width="150">작성일</th>
			<th width="100">조회수</th>
		</tr>
		
		<% for (BoardDTO boardDTO : list){ %>
		<tr>
			<td align="center"><%=boardDTO.getSeq() %></td>
			<td><%=boardDTO.getSubject() %></td>
			<td align="center"><%=boardDTO.getId() %></td>
			<td align="center"><%=new SimpleDateFormat("yyyy.MM.dd.").format(boardDTO.getLogtime()) %></td>
			<td align="center"><%=boardDTO.getHit() %></td>
			<% }//for %>
		</tr>
	</table>
<img src="../image/강지영.jpg" width="100" height="100" alt="강지영" 
onclick ="location.href='../index.jsp'" style="cursor: pointer;">
<%} //if %>
</form>
</body>
</html>






















