package hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hr.utils.ConnectionUtils;
import hr.vo.Emp;

public class EmpDao {

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