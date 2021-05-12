package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.DentalService;
import DTO.DetailService;

public class DetailServiceMapper implements RowMapper<DetailService>{

	@Override
	public DetailService mapRow(ResultSet rs) {

		DetailService ser = new DetailService();
		try {
			ser.setId(rs.getInt("id"));
			ser.setIdMedicalForm(rs.getInt("id_medical_form"));
			ser.setIdDentalService(rs.getInt("id_dental_service"));
			ser.setQuantity(rs.getInt("quantity"));
			ser.setPrice(rs.getDouble("price"));
			
			try {
				DentalService den = new DentalService();
				den = new DentalServiceMapper().mapRow(rs);
				ser.setDentalService(den);
			} catch (Exception e) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ser;
	}

}
