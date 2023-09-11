<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse:collapse;
}

#loginForm div{
	font-size: 8pt;
	font-weight: bold;
	color: red;
}
</style>
</head>
<body>
<form id = "loginForm" method="post" action="/boardMVC/member/login.do">
<table border="1" cellspacing ="0" cellpadding ="7">
		<tr>
				<th width ="100">아이디 </th>
				<td>
					<input type="text" id="id" name="id" placeholder="아이디 입력" size="15">
					<div id="idDiv"></div>
				</td>
		</tr>
		<tr >
				<td align ="center">비밀번호</td>
				<td><input type="text" id="pwd" name="pwd" placeholder= "비밀번호 입력" size="30">
					<div id="pwdDiv"></div>
				</td>
				
		</tr>
		
		<tr>
			<th colspan="2">
				<button type="button" id="loginBtn">로그인</button>
				<button type="button" id="writeBtn" onclick="location.href='/boardMVC/member/writeForm.do'">회원가입</button>
			</th>
		</tr>
</table>	
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
<!-- <script type="text/javascript">
function checkID(){
	var id = document.getElementById("id").value;
	var pwd = document.getElementById("pwd").value;
	
	if(id =="")
		document.getElementById("idDiv").innerText = "아이디를 입력하세요.";
	else if(pwd =="")
		document.getElementById("pwdDiv").innerText = "비밀번호를 입력하세요.";
}
</script> -->
<script type="text/javascript">
$(function(){
	$('#loginBtn').click(function(){
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#id').val()==''){
			$('#idDiv').text('아이디를 입력하세요.');
			$('#id').focus();
			
		}else if($('#pwd').val()==''){
			$('#pwdDiv').text('비밀번호를 입력하세요.');
			$('#pwd').focus();
		}else{
			$('#loginForm').submit();
			}
		});
});
</script>
<!-- <script type="text/javascript">
document.getElementById("writeBtn").addEventListener("click", function() {
    // 페이지 이동
    window.location.href = "http://localhost:8080/memberJSP/member/writeForm.jsp";
});
</script> -->

</body>
</html>