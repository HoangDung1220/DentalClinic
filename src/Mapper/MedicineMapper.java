package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import DTO.Medicine;
import DTO.TypeMedicine;

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
			m.setId(rs.getInt("id"));
			
			try {
				TypeMedicine type = new TypeMedicine();
				type.setName(rs.getString("name"));
				type.setCode(rs.getString("code"));
				m.setTypeMedicine(type);
				} catch (Exception e) {
					
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return m;
	}

}
