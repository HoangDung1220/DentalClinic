package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.Role;

public class RoleMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs) {
		Role role = new Role();
		try {
			role.setId(rs.getInt("id"));
			role.setCode(rs.getString("code"));
			role.setName(rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

}
