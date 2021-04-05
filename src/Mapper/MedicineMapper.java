package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.Medicine;

public class MedicineMapper implements RowMapper<Medicine>{

	@Override
	public Medicine mapRow(ResultSet rs) {
		Medicine m = new Medicine();
		try {
			m.setCodeMedicine(rs.getString("code_medicine"));
			m.setIdTypeMedicine(rs.getInt("id_typemedicine"));
			m.setNameMedicine(rs.getNString("name_medicine"));
			m.setPrice(rs.getDouble("price"));
			m.setQuantity(rs.getInt("quantity"));
			m.setUnit(rs.getNString("unit"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return m;
	}

}
