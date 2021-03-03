<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 id="top">사원수정</h3>

<form action="insertEmp" method="post" name="frm">
	employee_id <input type="number" name="employee_id"><br>
	first_name  <input name="first_name"><br>
	last_name   <input name="last_name"><br>
	email       <input type="email" id="email" name="email"><button type="button" id="btnEmail">중복체크</button>&nbsp;<span id="emailResult"></span><br>
	phone_number<input type="text" name="phone_number" id="btnEmail"><br>
	hire_date   <input type="date" name="hire_date"><br>
	job_id 		<select name="job_id">
				<option value="AC_ACCOUNT">Accounting Manager</option>
				</select> 
	<br>
	department_id 
	<input type="radio" id="department_id" name="department_id" value="10">기획
				 <br>
	manager_id 
	<input type="text" name="manager_id">
	<input type="text" name="name">
	<button type="button" id="btn">사원검색</button><br>	

	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>
</body>
</html>