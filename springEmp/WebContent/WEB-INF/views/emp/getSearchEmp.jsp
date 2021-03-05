<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
tr{cursor:pointer;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btnInsert").on("click", function(){
		location.href = "insertEmp";
	});
});
</script>
</head>
<body>
<h2>사원목록</h2>
<form action="getSearchEmp" name="searchFrm">
	<input type="hidden" name="page" value="1">
	부서 <input name="department_id" value="${empSearchVO.department_id}">
	JOB <input name="job_id" value="${empSearchVO.job_id}">
	NAME<input name="first_name" value="${empSearchVO.first_name}">
	<button>검색</button>
</form>
<table>
<c:forEach items="${list }" var="emp">
	<tr onclick="location.href='getEmp?employee_id=${emp.employee_id }'">
	<td>${emp.employee_id }</td><td>${emp.department_name }</td><td>${emp.job_title }</td></tr>
</c:forEach>
</table>
<my:paging paging="${paging}" jsFunc="goPage"/>
<script>
	function goPage(p){
		//location.href="getSearchEmp?page=" + p;
		searchFrm.page.value=p;
		searchFrm.submit();
	}
</script>
<button id="btnInsert">사원등록</button> 
</body>
</html>