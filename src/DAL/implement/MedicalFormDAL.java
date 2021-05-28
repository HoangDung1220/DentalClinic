package DAL.implement;

import java.sql.Date;
import java.util.List;

import DAL.IMedicalFormDAL;
import DTO.MedicalForm;
import Mapper.MedicalFormMapper;

public class MedicalFormDAL extends AbstractDAL<MedicalForm> implements IMedicalFormDAL {

	@Override
	public List<MedicalForm> findAll(int id_staff) {
		StringBuilder st =new StringBuilder("select *from medical_form inner join patient on medical_form.id_patient=patient.id ");
		st.append("inner join staff on medical_form.id_doctor=staff.id where medical_form.id_doctor=?");
		return query(st.toString(),new MedicalFormMapper(),id_staff);
	}

	@Override
	public MedicalForm findOne(int id) {
		StringBuilder st =new StringBuilder("select *from medical_form inner join patient on medical_form.id_patient=patient.id ");
		st.append("inner join staff on medical_form.id_doctor=staff.id where medical_form.id=?");
		List<MedicalForm> list = query(st.toString(),new MedicalFormMapper(),id);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public int insert(MedicalForm p) {
		String st ="insert into medical_form(id_patient,id_doctor,date_cure,status_before_cure,status_after_cure,content_cure) values(?,?,?,?,?,?)";
		return insert(st,p.getIdPatient(),p.getIdDoctor(),p.getDateCure(),p.getStatusBeforeCure(),p.getStatusAfterCure(),p.getContentCure());
	}

	@Override
	public void update(MedicalForm p) {
		String st ="update medical_form set status_before_cure=?, status_after_cure=?, content_cure=? where id=?";
		update(st,p.getStatusBeforeCure(),p.getStatusAfterCure(),p.getContentCure(),p.getId());
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

	@Override
	public List<MedicalForm> searchByIDPatient(int id) {
		StringBuilder st =new StringBuilder("select *from medical_form inner join patient on medical_form.id_patient=patient.id ");
		st.append("inner join staff on medical_form.id_doctor=staff.id where medical_form.id_patient=?");
		return query(st.toString(),new MedicalFormMapper(),id);
	}

}
