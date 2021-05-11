package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.Patient;

public class PatientMapper implements RowMapper<Patient>
{

	@Override
	public Patient mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		Patient p = new Patient();
		try {
			p.setId(rs.getInt("id"));
			p.setAddress(rs.getString("address"));
			p.setBirthday(rs.getDate("birthday"));
			p.setCreatedBy(rs.getString("created_by"));
			p.setCreatedDate(rs.getTimestamp("created_date"));
			p.setFullname(rs.getString("fullname"));
			p.setGender(rs.getByte("gender"));
			p.setiCard(rs.getString("icard"));
			p.setModifiedBy(rs.getString("modified_by"));
			p.setModifiedDate(rs.getTimestamp("modified_date"));
			p.setPhone(rs.getString("phone"));
			p.setStatus(rs.getInt("status"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return p;
	}

}