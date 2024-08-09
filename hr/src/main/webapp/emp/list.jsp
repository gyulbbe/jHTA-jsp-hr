<%@page import="hr.vo.Emp"%>
<%@page import="java.util.List"%>
<%@page import="hr.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 관리</title>
</head>
<body>
	<h1>전체 직원 목록</h1>
	<p>전체 직원 목록을 확인하세요</p>
	
	<table border="1" style="width:90%;">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>연락처</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
<%
	EmpDao empDao = new EmpDao();
	List<Emp> emps = empDao.getAllEmployees();
%>
<%
	for (Emp emp : emps) {
%>
			<tr>
				<td><%=emp.getId() %></td>
				<td><a href="detail.jsp?id=<%=emp.getId() %>"><%=emp.getFirstName() %></a></td>
				<td><%=emp.getEmail() %></td>
				<td><%=emp.getPhoneNumber() %></td>
				<td><a href="modifyForm.jsp?id=<%=emp.getId() %>">수정</a></td>
			</tr>
<%
	}
%>
		</tbody>
	</table>
</body>
</html>