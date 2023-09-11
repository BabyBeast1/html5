<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//쿠키
/*
Cookie[] ar = request.getCookies();
if(ar != null){
	for(int i=0; i<ar.length; i++){
		if(ar[i].getName().equals("memName")){
			ar[i].setMaxAge(0); //쿠키 삭제
			response.addCookie(ar[i]); //클라이언트에 보내기
		}
		
		if(ar[i].getName().equals("memId")){
			ar[i].setMaxAge(0); //쿠키 삭제
			response.addCookie(ar[i]); //클라이언트에 보내기
		}
	}
}
*/

//세션
session.removeAttribute("memName");
session.removeAttribute("memId");

/* session.invalidate(); //무효화 한번에 다 지울수 있음*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그아웃</h3>
</body>
</html>