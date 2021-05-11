package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.TypeMedicine;

public class TypeMedicineMapper implements RowMapper<TypeMedicine>{

	@Override
	public TypeMedicine mapRow(ResultSet rs) {
		TypeMedicine m = new TypeMedicine();
		try {
			m.setId(rs.getInt("id"));
			m.setCode(rs.getString("code"));
			m.setName(rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

}
