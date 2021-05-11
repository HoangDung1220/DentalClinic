package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.DentalService;

public class DentalServiceMapper implements RowMapper<DentalService>{

	@Override
	public DentalService mapRow(ResultSet rs) {
		DentalService d = new DentalService();
		
		try {
			d.setId(rs.getInt("id"));
			d.setNameService(rs.getString("name_service"));
			d.setUnit(rs.getString("unit"));
			d.setPrice(rs.getFloat("price"));
			d.setQuantity(rs.getInt("quantity"));
			d.setWarranty(rs.getString("warranty"));
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

}
