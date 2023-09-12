<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fmt:requestEncoding value="UTF-8"/>

<ul>
	<li>이 름 : ${param.name }</li><br>
	
	<li>나 이 : ${param.age } &emsp;
		<c:if test="${param.age >= 19 }">성인</c:if>
		<c:if test="${param.age < 19 }">청소년</c:if>
	</li><br>
	
	<li>
		색 깔 : ${param.color }
		<c:if test="${param.color == 'red' }">빨강</c:if>
		<c:if test="${param.color == 'green' }">초록</c:if>
		<c:if test="${param.color eq 'blue' }">파랑</c:if>
		<c:if test="${param.color eq 'magenta' }">자주</c:if>
		<c:if test="${param.color == 'cyan' }">하늘</c:if>
	</li><br>
	
	<li>
		색 깔 :
		<c:choose>
			<c:when test="${param.color == 'red' }">빨강</c:when>
			<c:when test="${param.color == 'green' }">초록</c:when>
			<c:when test="${param.color eq 'blue' }">파랑</c:when>
			<c:when test="${param.color eq 'magenta' }">자주</c:when>
			<c:otherwise>하늘</c:otherwise>
		</c:choose>
	</li><br>
	
	<li>
		취 미 : ${paramValues['hobby'][0] }
     		  ${paramValues['hobby'][1] }
     		  ${paramValues['hobby'][2] }
     		  ${paramValues['hobby'][3] }
     		  ${paramValues['hobby'][4] }
     	 <br><br>
     	 
     	취 미 : ${paramValues.hobby[0] }
     		  ${paramValues.hobby[1] }
     		  ${paramValues.hobby[2] }
     		  ${paramValues.hobby[3] }
     		  ${paramValues.hobby[4] }
     	 <br><br>
     	 
     	취 미 :
     	 <%-- for(String data: paramValues.hobby) --%>
     	 <c:forEach var="data" items="${paramValues.hobby}">
     	 	${data }
     	 </c:forEach>
	</li><br>
</ul>
</body>
</html>

<!-- 
request.getParameter() ===> ${param}
request.getParameterValues() ===> ${paramValues}
 -->