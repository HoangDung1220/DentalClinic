package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.MedicalForm;
import DTO.Patient;
import DTO.Staff;

public class MedicalFormMapper implements RowMapper<MedicalForm> {

	@Override
	public MedicalForm mapRow(ResultSet rs) {
		MedicalForm form = new MedicalForm();
		try {
			form.setId(rs.getInt("id"));
			form.setIdDoctor(rs.getInt("id_doctor"));
			form.setIdPatient(rs.getInt("id_patient"));
			form.setDateCure(rs.getDate("date_cure"));
			form.setStatusAfterCure(rs.getString("status_after_cure"));
			form.setStatusBeforeCure(rs.getString("status_before_cure"));
			form.setContentCure(rs.getString("content_cure"));
			
			try {
				Patient patient = new Patient();
				patient = new PatientMapper().mapRow(rs);
				form.setPatient(patient);
				Staff staff = new Staff();
				staff = new StaffMapper().mapRow(rs);
				form.setStaff(staff);
				} catch (Exception e) {
					
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return form;
	}
	

}
