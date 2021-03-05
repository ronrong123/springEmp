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
table{border-collapse: collapse;margin-bottom:10px;}
tr{cursor:pointer;}
tr th, td{padding:10px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btnInsert").on("click", function(){
		location.href="insertDept"
	});
});
</script>
</head>
<body>
<div align="center">
<h2>목록</h2>
<form action="getSearchDept" name="searchFrm">
	<input type="hidden" name="page" value="1">
	deptID <input name="department_id" value="${deptSearchVO.department_id}">
	deptNAME <input name="department_name" value="${deptSearchVO.department_name}">
	locationID<input name="location_id" value="${deptSearchVO.location_id}">
	<button>검색</button>
</form><br>
<table border="1">
<tr>
<th>department_id</th>
<th>department_name</th>
<th>manager_id</th>
<th>location_id</th>
</tr>
<c:forEach items="${list }" var="dept">
<tr onclick="location.href='getDept?department_id=${dept.department_id}'">
	<td>${dept.department_id }</td>
	<td>${dept.department_name }</td>
	<td>${dept.manager_id }</td>
	<td>${dept.location_id }</td>	
</tr>
</c:forEach>
</table>
<my:paging paging="${paging}" jsFunc="goPage" />
<script>
	function goPage(p){
		searchFrm.page.value=p;
		searchFrm.submit();
	}
</script>

<button id="btnInsert">등록</button>
</div>
</body>
</html>