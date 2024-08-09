<%@page import="hr.vo.Emp"%>
<%@page import="hr.dao.EmpDao"%>
<%@page import="hr.vo.EmpDetail"%>
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
	String email = request.getParameter("email");
	String phoneNumber = request.getParameter("phoneNumber");
	
	// 2. emp객체를 생성해서 요청파라미터 정보를 저장한다.
	Emp emp = new Emp();
	emp.setId(id);
	emp.setEmail(email);
	emp.setPhoneNumber(phoneNumber);
	
	// 3. EmpDao 객체를 생성하고, updateDept()메소드를 실행한다.
	EmpDao empDao = new EmpDao();
	empDao.updateEmployee(emp);
	
	// 4. 재요청 url을 응답으로 보낸다.
	response.sendRedirect("list.jsp");
%>