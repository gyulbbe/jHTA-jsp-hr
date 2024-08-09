<%@page import="hr.vo.EmpDetail"%>
<%@page import="hr.vo.Dept"%>
<%@page import="hr.vo.DeptDetail"%>
<%@page import="java.util.Optional"%>
<%@page import="hr.dao.DeptDao"%>
<%@page import="hr.dao.EmpDao"%>
<%@page import="hr.vo.Loc"%>
<%@page import="java.util.List"%>
<%@page import="hr.dao.LocDao"%>
<%@page import="hr.vo.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 정보 수정</title>
</head>
<body>
<h1>직원 정보 수정 화면</h1>
<p>이메일, 연락처를 수정해보세요.</p>
	
<%
	int id = Integer.parseInt(request.getParameter("id"));

	//empDao.getEmployeeById가 반환 타입이 EmpDetail이라서 어쩔 수 없이 EmpDetail사용
	EmpDao empDao = new EmpDao();
	EmpDetail empDetail = empDao.getEmployeeById(id);
%>
	<form method="post" action="update.jsp">
		<div>
			<label>아이디</label><br>
			<input type="text" name="id" value="<%=empDetail.getId() %>" readonly="readonly">
		</div>
		<div>
			<label>이름</label><br />
			<input type="text" name="name" value="<%=empDetail.getFirstName() %> <%=empDetail.getLastName() %>" readonly="readonly"/>
		</div>
		<div>
			<label>이메일</label><br />
			<input type="text" name="email" value="<%=empDetail.getEmail() %>" />
		</div>
		<div>
			<label>연락처</label><br />
			<input type="text" name="phoneNumber" value="<%=empDetail.getPhoneNumber() %>" />
		</div>
		<button type="submit">수정</button>
	</form>
</body>
</html>