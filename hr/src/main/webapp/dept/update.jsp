<%@page import="hr.dao.DeptDao"%>
<%@page import="hr.vo.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	요청 URL
		http://localhost/hr/dept/update.jsp
	요청 URI
		hr/dept/update.jsp
	폼 데이터
		id=xxx&name=xxx&managerId=xxx&locationId=xxx
		
	요청파라미터 정보
	----------------------------------------------------
	name				value
	----------------------------------------------------
	id					xxx				부서아이디
	name				xxx				부서이름
	managerId			xxx				부서관리자 직원아이디
	locationId			xxx				소재지 아이디
	----------------------------------------------------
-->
<%
	// 1. 요청파라미터 정보 조회하기
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	int managerId = Integer.parseInt(request.getParameter("managerId"));
	int locationId = Integer.parseInt(request.getParameter("locationId"));
	
	// 2. Dept객체를 생성해서 요청파라미터 정보를 저장한다.
	Dept dept = new Dept();
	dept.setId(id);
	dept.setName(name);
	dept.setManagerId(managerId);
	dept.setLocationId(locationId);
	
	// 3. DeptDao 객체를 생성하고, updateDept()메소드를 실행한다.
	DeptDao deptDao = new DeptDao();
	deptDao.updateDept(dept);
	
	// 4. 재요청 url을 응답으로 보낸다.
	response.sendRedirect("list.jsp");
%>