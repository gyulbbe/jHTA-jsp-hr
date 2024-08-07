<%@page import="hr.vo.JobList"%>
<%@page import="java.util.List"%>
<%@page import="hr.dao.JobDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직종관리</title>
</head>
<body>
	<h1>직종목록</h1>
	<p>전체 직종목록을 표시합니다.</p>
	
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>제목</th>
				<th>최소급여</th>
				<th>최대급여</th>
			</tr>
		</thead>
		<tbody>
<%
	JobDao jDao = new JobDao();
	List<JobList> jobs = jDao.getAllJobs();
	for (JobList job : jobs) {
%>
			<tr>
				<th><%=job.getId() %></th>
				<th><%=job.getTitle() %></th>
				<th><%=job.getMinSalary() %></th>
				<th><%=job.getMaxSalary() %></th>
			</tr>
<%
	}
%>
		</tbody>
	</table>
	
</body>
</html>