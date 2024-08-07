package hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hr.utils.ConnectionUtils;
import hr.vo.JobList;

public class JobDao {

	public List<JobList> getAllJobs() throws SQLException {
		String sql = """
				select job_id, job_title, min_salary, max_salary
				from jobs
				order by job_id
		""";
		
		List<JobList> jobs = new ArrayList<JobList>();
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			JobList vo = new JobList();
			vo.setId(rs.getString("job_id"));
			vo.setTitle(rs.getString("job_title"));
			vo.setMinSalary(rs.getInt("min_salary"));
			vo.setMaxSalary(rs.getInt("max_salary"));
			
			jobs.add(vo);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return jobs;
	}
}

