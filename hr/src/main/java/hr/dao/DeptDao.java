package hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import hr.utils.ConnectionUtils;
import hr.vo.Dept;
import hr.vo.DeptDetail;
import hr.vo.DeptList;

public class DeptDao {

	/** 
	 * Dept객체를 전달받아 수정한다.
	 * @param dept
	 * @throws SQLException
	 */
	public void updateDept(Dept dept) throws SQLException {
		String sql = """
			update departments
			set department_name = ?,
			manager_id = ?,
			location_id = ?
			where department_id = ?
		""";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dept.getName());
		pstmt.setInt(2, dept.getManagerId());
		pstmt.setInt(3, dept.getLocationId());
		pstmt.setInt(4, dept.getId());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public Dept getDeptById(int deptId) throws SQLException {
		String sql = """
			select *
			from departments
			where department_id = ?	
		""";
		
		Dept dept = null;
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			dept = new Dept();
			dept.setId(rs.getInt("department_id"));
			dept.setName(rs.getString("department_name"));
			dept.setManagerId(rs.getInt("manager_id"));
			dept.setLocationId(rs.getInt("location_id"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return dept;
	}
	
	/**
	 * 새 부서정보가 있는 Dept객체를 전달받아서 저장시킨다.
	 * @param dept 새 부서정보
	 * @throws SQLException
	 */
	public void insertDept(Dept dept) throws SQLException {
		String sql = """
			insert into departments
			(department_id, department_name, manager_id, location_id)
			values
			(departments_seq.nextval, ?, ?, ?)	
		""";
	
	
	Connection con = ConnectionUtils.getConnection();
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1, dept.getName());
	pstmt.setInt(2, dept.getManagerId());
	pstmt.setInt(3, dept.getLocationId());
	pstmt.executeUpdate();
	
	pstmt.close();
	con.close();
	}
	
	/**
	 * 부서아이디를 전달받아서 해당 부서의 상세정보를 반환한다.
	 * @param deptId
	 * @return
	 * @throws SQLException
	 */
	public Optional<DeptDetail> getDeptDetail(int deptId) throws SQLException {
		String sql = """
			select department_id, department_name, city, country_name
			from dept_detail_view
			where department_id = ?
		""";
		
		DeptDetail dept = null;
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			dept = new DeptDetail();
			dept.setId(rs.getInt("department_id"));
			dept.setName(rs.getString("department_name"));
			dept.setCity(rs.getString("city"));
			dept.setCountry(rs.getString("country_name"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return Optional.ofNullable(dept);
	}
	
	/**
	 * 모든 부서정보를 반환한다.
	 * @return 부서목록
	 * @throws SQLException
	 */
	public List<DeptList> findAllDepts() throws SQLException {
		String sql = """
				SELECT department_id
				    , department_name
				    , first_name
				    , city
				    , cnt
				FROM dept_detail_view
				WHERE first_name IS NOT NULL
				ORDER BY department_id ASC
		""";
		
		List<DeptList> depts = new ArrayList<DeptList>();
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			DeptList vo = new DeptList();
			vo.setId(rs.getInt("department_id"));
			vo.setName(rs.getString("department_name"));
			vo.setManagerName(rs.getString("first_name"));
			vo.setCity(rs.getString("city"));
			vo.setCnt(rs.getInt("cnt"));
			
			depts.add(vo);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return depts;
	}
}
