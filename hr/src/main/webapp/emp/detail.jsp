<%@page import="hr.vo.EmpDetail"%>
<%@page import="hr.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원관리</title>
</head>
<body>
<%
	// 1. 아이디 받아오기
	int id = Integer.parseInt(request.getParameter("id"));

	// 2. 받아온 아이디로 불러오기
	EmpDao empDao = new EmpDao();
	EmpDetail empDetail = empDao.getEmployeeById(id);
%>
	<h1>직원 상세 정보</h1>
	<p>직원의 상세정보를 확인하세요</p>
	
	<h3>직원 정보</h3>
	<table border="1" style="width: 90%;">
		<tr>
			<th>아이디</th><td><%=empDetail.getId() %></td>
			<th>이름</th><td><%=empDetail.getFirstName() %> <%=empDetail.getLastName() %></td>
		</tr>
		<tr>
			<th>이메일</th><td><%=empDetail.getEmail() %></td>
			<th>전화번호</th><td><%=empDetail.getPhoneNumber() %></td>
		</tr>
		<tr>
			<th>급여</th><td><%=empDetail.getSalary() %></td>
			<th>커미션</th><td><%=empDetail.getCommissionPct() %></td>
		</tr>
		<tr>
			<th>직종</th><td><%=empDetail.getJobId() %></td>
			<th>입사일</th><td><%=empDetail.getHireDate() %></td>
		</tr>
	</table>
	
	<h3>소속 부서 정보</h3>
	<table border="1" style="width: 90%">
		<tbody>
			<tr>
				<th>부서 아이디</th>
				<td><%=empDetail.getDeptId() %></td>
				<th>부서명</th>
				<td><%=empDetail.getDeptName() %></td>
			</tr>
			<tr>
				<th>관리자명</th>
				<td><%=empDetail.getDeptManagerFirstName() %> 
				<%=empDetail.getDeptManagerLastName() %></td>
				<th>소재지</th>
				<td><%=empDetail.getCity() %></td>
			</tr>
			
		</tbody>
	</table>
	
	<h3>급여 상세 정보</h3>
	<table border="1" style="width: 90%;">
		<tr>
			<th>급여</th><td><%=empDetail.getSalary() %></td>
			<th>커미션</th><td><%=empDetail.getCommissionPct() %></td>
		</tr>
		<tr>
			<th>연봉</th><td><%=empDetail.getAnnualSalary() %></td>
			<th>급여등급</th><td><%=empDetail.getSalaryGrade() %></td>
		</tr>
	</table>
</body>
</html>