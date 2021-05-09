package DAL.implement;

import java.util.List;

import DAL.IMedicalFormDAL;
import DTO.MedicalForm;

public class MedicalFormDAL extends AbstractDAL<MedicalForm> implements IMedicalFormDAL {

	@Override
	public List<MedicalForm> findAll() {
		// TODO Auto-generated method stub
		return null;
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

}
