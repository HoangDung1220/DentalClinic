package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.Role;
import DTO.Staff;

public class StaffMapper implements RowMapper<Staff>{

	@Override
	public Staff mapRow(ResultSet rs) {
		Staff s = new Staff();
		try {
			s.setId(rs.getInt("id"));
			s.setAddress(rs.getString("address"));
			s.setBirthday(rs.getDate("birthday"));
			s.setCreatedBy(rs.getString("created_by"));
			s.setCreatedDate(rs.getTimestamp("created_date"));
			s.setDateStartWork(rs.getDate("date_start_work"));
			s.setEmail(rs.getString("email"));
			s.setFullname(rs.getString("fullname"));
			s.setGender(rs.getBoolean("gender"));
			s.setiCard(rs.getString("icard"));
			s.setIdRole(rs.getInt("id_role"));
			s.setModifiedBy(rs.getString("modified_by"));
			s.setModifiedDate(rs.getTimestamp("modified_date"));
			s.setPassword(rs.getString("password"));
			s.setPhone(rs.getString("phone"));
			s.setUsername(rs.getString("username"));
			try {
				Role r = new Role();
				r.setId(rs.getInt("id"));
				r.setCode(rs.getString("code"));
				r.setName(rs.getString("name"));
				s.setRole(r);
				
			}
			catch (Exception e) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}

}
