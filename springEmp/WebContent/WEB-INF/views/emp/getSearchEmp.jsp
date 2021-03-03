<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<ul>
<c:forEach items="${list }" var="emp">
	<li><a href="getEmp?employee_id=${emp.employee_id }">${emp.employee_id }, ${emp.department_name },  ${emp.job_title }, ${emp.salary }</a></li>
</c:forEach>
</ul>
<button id="btnInsert">사원등록</button>
</body>
</html>