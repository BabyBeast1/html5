<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

#currentPaging{
	border: 1px solid #ccc;
	margin: 5px;
	padding: 5px 8px;
	color: red;
	cursor: pointer;
}
#paging{
	color: black;
	padding: 5px 8px;
	margin: 5px;
	cursor: pointer;
}
.subjectA{
	text-decoration: none;
	color: black;
}
.subjectA:link{ color: black; text-decoration: none; }
.subjectA:visited{ color: black; text-decoration: none; }
.subjectA:hover{
	text-decoration: underline;
	color: green;
}
.subjectA:active{ color: black; text-decoration: none; }
</style>
</head>
<body>

<c:if test="${ requestScope.list != null }">

	<table border = "1" frame="hsides" rules="rows">
		<tr>
			<th width="100">글번호</th>
			<th width="400">제목</th>
			<th width="150">작성자</th>
			<th width="150">작성일</th>
			<th width="100">조회수</th>
		</tr>
	<c:forEach var="boardDTO" items="${list }">
		
		
		<tr>
			<td align="center">${boardDTO.seq}</td>
			<td>
				<a class="subjectA" href="javascript:void(0)"
				   onclick="isLogin('${sessionScope.memId }', ${boardDTO.seq} , ${pg} )">${boardDTO.subject}</a>
			</td>
			<td align="center">${ boardDTO.id}</td>
			<td align="center"><fmt:formatDate value="${boardDTO.logtime}" pattern="yyyy.MM.dd."/></td>
			<td align="center">${ boardDTO.hit}</td>
		</tr>
	</c:forEach>
	</table>
	
	<div style="border: 1px blue solid; width:900px; text-align: center;">
	${boardPaging.pagingHTML}
	</div>
	
</c:if>
<script type="text/javascript">
function boardPaging(pg){
	location.href = "boardList.do?pg=" + pg;
}

function isLogin(id, seq, pg){
	//alert(id);
	if(id == 'null') alert("먼저 로그인하세요");
	else location.href = "/boardMVC/board/boardView.do?seq=" + seq + "&pg=" + pg;
}
</script>

</form>
</body>
</html>

