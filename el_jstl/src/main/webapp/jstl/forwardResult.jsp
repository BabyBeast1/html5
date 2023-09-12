<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과 list = ${requestScope.list } <br>

세번째 항목 = ${requestScope.list[2] } <br>

결과 list2 = ${requestScope.list2 } <br>

이름 = ${ requestScope.list2[0].getName() } &emsp; 나이 = ${ requestScope.list2[0].getAge() }<br>
이름 = ${ requestScope.list2[1].getName() } &emsp; 나이 = ${ requestScope.list2[1].getAge() }<br>
이름 = ${ requestScope.list2[2].getName() } &emsp; 나이 = ${ requestScope.list2[2].getAge() }<br>
<br>

<h3>메소드명을 변수명처럼 사용</h3>

이름 = ${ requestScope.list2[0].name } &emsp; 나이 = ${ requestScope.list2[0].age }<br>
이름 = ${ requestScope.list2[1].name } &emsp; 나이 = ${ requestScope.list2[1].age }<br>
이름 = ${ requestScope.list2[2].name } &emsp; 나이 = ${ requestScope.list2[2].age }<br>

<h3>forEach</h3>
<h5>list2를 pageScope -> requestScope -> sessionScope -> application 순서로 찾는다.</h5>
<c:forEach var="personDTO" items="${ requestScope.list2 }"> <%-- for(PersonDTO personDTO : list2){ } 와 같음 --%>
	이름 = ${ personDTO.name } &emsp; 나이 = ${ personDTO.age }<br>
</c:forEach>
</body>
</html>













