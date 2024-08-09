package hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hr.utils.ConnectionUtils;
import hr.vo.Emp;
import hr.vo.EmpDetail;

public class EmpDao {

	/**
	 * Emp객체를 받아 수정한다.
	 * @param emp
	 * @throws SQLException
	 */
	public void updateEmployee(Emp emp) throws SQLException {
		String sql = """
			update employees
			set email = ?,
			phone_number = ?
			where employee_id = ?
		""";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, emp.getEmail());
		pstmt.setString(2, emp.getPhoneNumber());
		pstmt.setInt(3, emp.getId());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	/**
	 * 아이디를 가지고 모든 정보를 불러오기
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public EmpDetail getEmployeeById(int id) throws SQLException {
		String sql = """
		SELECT 
		    e.*, d.*, 
		    l.city, g.sal_grade, 
		    m.first_name mgr_first_name, 
		    m.last_name mgr_last_name, 
		    e.SALARY * 12 + e.SALARY * NVL(e.COMMISSION_PCT, 0) * 12 AS annual_salary
		FROM 
		    employees e
		JOIN 
		    departments d ON e.department_id = d.department_id
		JOIN 
		    locations l ON d.location_id = l.location_id
		JOIN 
		    salary_grades g ON e.salary BETWEEN g.min_salary AND g.max_salary
		JOIN
            employees m ON d.manager_id = m.employee_id
		WHERE e.employee_id = ?
		""";

		EmpDetail empDetail = null;
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			empDetail = new EmpDetail();
			empDetail.setId(rs.getInt("employee_id"));
			empDetail.setFirstName(rs.getString("first_name"));
			empDetail.setLastName(rs.getString("last_name"));
			empDetail.setEmail(rs.getString("email"));
			empDetail.setPhoneNumber(rs.getString("phone_number"));
			empDetail.setHireDate(rs.getDate("hire_date"));
			empDetail.setJobId(rs.getString("job_id"));
			empDetail.setSalary(rs.getDouble("salary"));
			empDetail.setCommissionPct(rs.getDouble("commission_pct"));
			empDetail.setManagerId(rs.getInt("manager_id"));
			empDetail.setDeptId(rs.getInt("department_id"));
			empDetail.setDeptName(rs.getString("department_name"));
			empDetail.setCity(rs.getString("city"));
			empDetail.setAnnualSalary(rs.getDouble("annual_salary"));
			empDetail.setSalaryGrade(rs.getString("sal_grade"));
			empDetail.setDeptManagerFirstName(rs.getString("mgr_first_name"));
			empDetail.setDeptManagerLastName(rs.getString("mgr_last_name"));
			
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return empDetail;
	}
	
	/**
	 * 모든 직원정보를 조회해서 목록으로 반환한다.
	 * @return 모든 직원정보 목록
	 * @throws SQLException
	 */
	public List<Emp> getAllEmployees() throws SQLException {
		String sql = """
			select *
			from employees
			order by employee_id asc
		""";
		
		List<Emp> employees = new ArrayList<>();
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Emp emp = new Emp();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommisionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDeptId(rs.getInt("department_id"));
			
			employees.add(emp);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return employees;
	}
	
	/**
	 * 부서아이디를 전달받아서 소속부서가 일치하는 직원정보를 조회해서 반환한다.
	 * @param deptId
	 * @return
	 * @throws SQLException
	 */
	public List<Emp> getEmployeesByDeptId(int deptId) throws SQLException {
		String sql = """
			select employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id
			from employees
			where department_id = ?
			order by employee_id asc
		""";
		
		List<Emp> employees = new ArrayList<Emp>();
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommisionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDeptId(rs.getInt("department_id"));
			
			employees.add(emp);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return employees;
	}
}