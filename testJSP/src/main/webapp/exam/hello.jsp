<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
//전역변수, 1번 수행
String name = "홍길동";
int age = 26;
%>    

<%
//지역변수, 요청시 마다 호출
age++;

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello JSP!! <br>

안녕하세요 JSP!! <br>

나의 이름은 <%=name%>이고 내 나이는 <%=age%>살 입니다.<br>

<% out.println("나의 이름은 " + name + " 이고 내 나이는 " + age + "살 입니다."); %>
</body>
</html>








