package DAL.implement;

import java.sql.Date;
import java.util.List;

import DAL.IMedicalFormDAL;
import DTO.MedicalForm;
import Mapper.MedicalFormMapper;

public class MedicalFormDAL extends AbstractDAL<MedicalForm> implements IMedicalFormDAL {

	@Override
	public List<MedicalForm> findAll() {
		StringBuilder st =new StringBuilder("select *from medical_form inner join patient on medical_form.id_patient=patient.id ");
		st.append("inner join staff on medical_form.id_doctor=staff.id");
		return query(st.toString(),new MedicalFormMapper());
	}

	@Override
	public MedicalForm findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MedicalForm p) {
		String st ="insert into medical_form(id_patient,id_doctor,date_cure,status_before_cure,status_after_cure,content_cure) values(?,?,?,?,?,?)";
		return insert(st,p.getIdPatient(),p.getIdDoctor(),p.getDateCure(),p.getStatusBeforeCure(),p.getStatusAfterCure(),p.getContentCure());
	}

	@Override
	public void update(MedicalForm p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MedicalForm> search(boolean isName, boolean isDate, String name, Date date) {
		StringBuilder st = new StringBuilder();
		st.append("select *from medical_form inner join patient on medical_form.id_patient=patient.id ");
		st.append("inner join staff on medical_form.id_doctor=staff.id");
		if (isName && !isDate) {
			st.append(" where patient.fullname like '%"+name+"%'");
		} else 	
			if (!isName && isDate) {
				st.append(" where medical_form.date_cure like '%"+date+"%'");
			} else 
				if (isName && isDate) {

					st.append(" where patient.fullname like '%"+name+"%' and medical_form.date_cure like '%"+date+"%'");
			}

			
		
		return query(st.toString(),new MedicalFormMapper());
	}

}
