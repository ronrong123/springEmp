<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btnUpd").on("click", function(){
		location.href="updateEmp?employee_id=${emp.employee_id }";
		//location.assing("updateEmp?employee_id=${emp.employee_id }");
	});
});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
파라미터  ${empVO }
<hr>
사번 : ${emp.employee_id } <br>
이름 : ${emp.first_name } ${emp.last_name }<br>
이메일 : ${emp.email }<br>
급여 : ${emp.salary }<br>
부서 : ${emp.department_id }
<br><br>
<button id="btnUpd">수정</button>
<a href="deleteEmp?employee_id=${emp.employee_id }">삭제</a>
<a href="getSearchEmp">목록으로</a>
</body>
</html>