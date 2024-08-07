<%@page import="hr.vo.Emp"%>
<%@page import="java.util.List"%>
<%@page import="hr.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>직원목록</h1>
	<p>전체 직원목록을 표시합니다.</p>
	
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>입사 날짜</th>
			</tr>
		</thead>
		<tbody>
<%
	EmpDao eDao = new EmpDao();
	List<Emp> emps = eDao.getAllEmployees();
	for(Emp emp : emps) {
%>
			<tr>
				<th><%=emp.getId() %></th>
				<th><%=emp.getFirstName() %></th>
				<th><%=emp.getEmail() %></th>
				<th><%=emp.getHireDate() %></th>
			</tr>
<%
	}
%>
		</tbody>
	</table>
</body>
</html>