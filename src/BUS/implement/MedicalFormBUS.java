package BUS.implement;

import java.sql.Date;
import java.util.List;

import BUS.IMedicalFormBUS;
import DAL.implement.MedicalFormDAL;
import DTO.MedicalForm;

public class MedicalFormBUS implements IMedicalFormBUS{

	MedicalFormDAL form = new MedicalFormDAL();
	@Override
	public List<MedicalForm> findAll() {
		return form.findAll();
	}

	@Override
	public MedicalForm findOne(int id) {
		// TODO Auto-generated method stub
		return form.findOne(id);
	}

	@Override
	public int insert(MedicalForm p) {
		// TODO Auto-generated method stub
		return form.insert(p);
	}

	@Override
	public void update(MedicalForm p) {
		form.update(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MedicalForm> search(boolean isName, boolean isDate, String name, Date date) {
		return form.search(isName, isDate, name, date);
	}

	@Override
	public List<MedicalForm> searchByIDPatient(int id) {
		return form.searchByIDPatient(id);
	}

}
