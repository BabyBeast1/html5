<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	border-collapse: collapse;
}
th, td{
	padding: 5px;
}

#boardWriteForm div {
	color : red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<%-- <form id = "boardWriteForm" method="post" action="boardWrite.jsp"> --%>
	 <form id = "boardWriteForm">
	<h3>글쓰기</h3>
	<table border="1" cellspacing ="0" cellpadding ="5">
		<tr>
				<th width="">제목</th>
				<td>
					<input type="text" id="subject" name="subject" size="50" >
					<div id="subjectDiv"></div>
				</td>
		</tr>
		<tr >
				<th>내용</th>
				<td><textarea type="text" id="content" name="content"rows="15" cols="50"></textarea>
					<div id="contentDiv"></div>
				</td>
				
		</tr>
		
		<tr>
			<th colspan="2" align="center">
				<input type="button" id="boardWriteBtn" value="글쓰기">
				<input type="reset" id="resetBtn" value="다시작성">
			</th>
		</tr>
</table>	

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="http://localhost:8080/memberJSP/js/boardWrite.js"></script>
</body>
</html>