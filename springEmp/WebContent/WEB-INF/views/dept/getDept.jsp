<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>상세보기</h2>
DeptID : ${dept.department_id }<br>
DeptNAME : ${dept.department_name }<br>
ManagerID : ${dept.manager_id }<br>
LocationId : ${dept.location_id }
<br><br>
<button id="btnIpdate">수정하기</button>
<button onclick="location.href='getSearchDept'">목록으로</button>
</div>

</body>
</html>