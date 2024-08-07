package hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hr.utils.ConnectionUtils;
import hr.vo.Loc;

public class LocDao {

	/**
	 * 모든 소재지 정보를 조회해서 반환한다.
	 * @return 소재지정보 목록
	 * @throws SQLException
	 */
	public List<Loc> getAllLocations() throws SQLException {
		String sql = """
			select *
			from locations
			order by location_id asc
		""";
		
		List<Loc> locations = new ArrayList<Loc>();
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Loc loc = new Loc();
			loc.setId(rs.getInt("location_id"));
			loc.setAddress(rs.getString("street_address"));
			loc.setPostalCode(rs.getString("postal_code"));
			loc.setCity(rs.getString("city"));
			loc.setState(rs.getString("STATE_PROVINCE"));
			loc.setCountryId(rs.getString("country_id"));
			locations.add(loc);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return locations;
	}
}
