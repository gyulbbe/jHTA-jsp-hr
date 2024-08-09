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
<title>부서 정보 수정</title>
</head>
<body>
<h1>부서 정보 수정 화면</h1>
<p>부서이름, 관리자, 소재지를 수정해보세요.</p>
	
<%
	EmpDao empDao = new EmpDao();
	List<Emp> employees = empDao.getAllEmployees();
	
	// 요청파라미터 정보 조회
	int deptId = (Integer.parseInt(request.getParameter("id")));
	
	// 수정할 부서정보 조회
	DeptDao deptDao = new DeptDao();
	Dept dept = deptDao.getDeptById(deptId);
%>
	<form method="post" action="update.jsp">
		<div>
			<label>아이디</label><br>
			<input type="text" name="id" value="<%=dept.getId() %>" readonly="readonly">
		</div>
		<div>
			<label>부서이름</label><br />
			<input type="text" name="name" value="<%=dept.getName() %>"/>
		</div>
		<div>
			<label>부서관리자</label><br />
			<select name="managerId" >
<%
	for (Emp emp : employees) {
%>
				<option value="<%=emp.getId() %>" <%=emp.getId() == dept.getId() ? "selected" : ""%>>
				<%=emp.getFirstName() %> <%=emp.getLastName() %>
				</option>
<%
	}
%>
			</select>
		</div>
<%	
LocDao locDao = new LocDao();
List<Loc> locs = locDao.getAllLocations();
%>
		<div>
			<label>부서소재지</label><br />
			<select name="locationId" >
<%
	for (Loc loc : locs) {
%>
				<option value="<%=loc.getId() %>"<%=loc.getId() == dept.getLocationId() ? "selected" : "" %>>
				<%=loc.getCity() %>(<%=loc.getCountryId() %>)
				</option>
<%
	}
%>
			</select>
		</div>
		<button type="submit">수정</button>
	</form>
</body>
</html>