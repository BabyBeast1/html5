<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>
<%--${ sessionScope.memName} 님 로그인 --%>  ${memName }님 로그인
</h3>

<input type="button" value="로그아웃" 
	   onclick="location.href='http://localhost:8080/boardMVC/member/logout.do'">







