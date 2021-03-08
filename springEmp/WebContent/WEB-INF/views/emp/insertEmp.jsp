<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 id="top">사원등록</h3>
<form:form modelAttribute="empVO" action="insertEmp" method="post" path="frm">
	employee_id <form:input path="employee_id" /><br>
	first_name  <form:input path="first_name" />
				<form:errors path="first_name" cssClass="error" style="color:red"/><br>
	email       <form:input type="email" path="email" />
				<form:errors path="email" cssClass="error" style="color:red"/><br>
	last_name   <form:input path="last_name" />
				<form:errors path="last_name" cssClass="error" style="color:red"/>
				<!-- <button type="button" id="btnEmail">중복체크</button>&nbsp;<span id="emailResult"></span> --><br>
	phone_number<form:input type="text" path="phone_number" /><br>
	hire_date   <form:input type="date" path="hire_date" /><br>
	department_id 
	<form:radiobuttons path="department_id" items="${deptList }" itemLabel="department_name" itemValue="department_id"/>기획
				 <br>
	job_id 		<form:select path="job_id">
				<option value="">선택</option>
				<form:options items="${jobList }" itemLabel="job_title" itemValue="job_id"/>
				</form:select> 
	<br>
	manager_id 
	<form:input path="manager_id" />
	<input type="text" name="name">
	<button type="button" id="btn">사원검색</button><br>	

	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form:form>
</body>
</html>