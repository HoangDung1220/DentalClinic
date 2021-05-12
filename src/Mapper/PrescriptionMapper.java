package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.Medicine;
import DTO.Prescription;

public class PrescriptionMapper implements RowMapper<Prescription> {

	@Override
	public Prescription mapRow(ResultSet rs) {
		Prescription pre = new Prescription();
		try {
			pre.setId(rs.getInt("id"));
			pre.setIdMedicalForm(rs.getInt("id_medical_form"));
			pre.setIdMedicine(rs.getInt("id_medicine"));
			pre.setNote(rs.getString("note"));
			pre.setPrice(rs.getDouble("price"));
			pre.setQuantity(rs.getInt("quantity"));
			pre.setUsage(rs.getString("usages"));
			
			try {
				Medicine m = new Medicine();
				m = new MedicineMapper().mapRow(rs);
				pre.setMedicine(m);
			}
			catch (Exception e) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pre;
	}

}
