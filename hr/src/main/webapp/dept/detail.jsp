<%@page import="java.util.Optional"%>
<%@page import="java.util.List"%>
<%@page import="hr.vo.Emp"%>
<%@page import="hr.dao.EmpDao"%>
<%@page import="hr.vo.DeptDetail"%>
<%@page import="hr.dao.DeptDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서관리</title>
</head>
<body>
	<h1>부서 상세정보</h1>
	<p>부서의 상세정보와 소속직원 목록을 표시합니다.</p>
	<!-- 
		요청 URL
			http://localhost/ht/dept/deatil.jsp?id=xxx
		요청 URI
			/hr/dept/detail.jsp
		쿼리스트링
			id=xxx
	 -->
<%
	String value = request.getParameter("id");
	int deptId = Integer.parseInt(value);

	DeptDao deptDao = new DeptDao();
	Optional<DeptDetail> optional = deptDao.getDeptDetail(deptId);
%>

	<h3>부서 상세정보</h3>
<%
	if(optional.isEmpty()){
%>
		<p>부서정보를 검색할 수 없습니다.</p>
<%
	} else {
		DeptDetail dept = optional.get();
%>
	<table border="1" style="width:90%">
		<tbody>
			<tr>
				<th>아이디</th>
				<th><%=dept.getId() %></th>
				<th>부서명</th>
				<th><%=dept.getName() %></th>
			</tr>
			<tr>
				<th>소재지 도시명</th>
				<th><%=dept.getCity() %></th>
				<th>소재지 국가명</th>
				<th><%=dept.getCountry() %></th>
			</tr>
		</tbody>
	</table>
	
<%
	EmpDao empDao = new EmpDao();
	List<Emp> emps = empDao.getEmployeesByDeptId(deptId);
%>
	
	<h3>소속 직원 목록</h3>
	<table border="1" style="width:90%">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>입사일</th>
				<th>직종</th>
				<th>급여</th>
			</tr>
		</thead>
<%
	if (emps.isEmpty()) { 
%>
			<tr>
				<td colspan="6">소속된 직원이 없습니다.</td>
			</tr>
<%
	} else { 
	for (Emp emp : emps) { 
%>
		<tbody>
			<tr>
				<td><%=emp.getId() %></td>
				<td><%=emp.getFirstName() %></td>
				<td><%=emp.getPhoneNumber() %></td>
				<td><%=emp.getHireDate() %></td>
				<td><%=emp.getJobId() %></td>
				<td><%=emp.getSalary() %></td>
			</tr>
		</tbody>
<%
		}
	}
%>
	</table>
<%
	}
%>
</body>
</html>