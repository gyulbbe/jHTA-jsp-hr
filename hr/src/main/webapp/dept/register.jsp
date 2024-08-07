<%@page import="hr.dao.DeptDao"%>
<%@page import="hr.vo.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		요청 URL
			http://localhost/ht/dept/register.jsp
		요청 URI
			/hr/dept/register.jsp
		폼 데이터
			name=xxx&managerId=xxx&locationId=xxx
			
		요청파라미터 정보
		----------------------------------------
			name			value
		----------------------------------------
			name			xxx
			managerId		xxx
			locationId		xxx
		----------------------------------------
	*/
	
	//요청 파라미터 값 조회하기
	String name = request.getParameter("name");
	int managerId = Integer.parseInt(request.getParameter("managerId"));
	int locationId = Integer.parseInt(request.getParameter("locationId"));
	
	// Dept객체를 생성해서 요청파라미터 값을 담는다.
	Dept dept = new Dept();
	dept.setName(name);
	dept.setManagerId(managerId);
	dept.setLocationId(locationId);
	
	DeptDao deptDao = new DeptDao();
	
	deptDao.insertDept(dept);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>