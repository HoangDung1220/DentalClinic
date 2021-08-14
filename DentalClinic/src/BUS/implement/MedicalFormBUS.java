package BUS.implement;

import java.sql.Date;
import java.util.List;

import BUS.IMedicalFormBUS;
import DAL.implement.MedicalFormDAL;
import DTO.MedicalForm;

public class MedicalFormBUS implements IMedicalFormBUS{

	MedicalFormDAL form = new MedicalFormDAL();
	@Override
	public List<MedicalForm> findAll(int id_staff) {
		return form.findAll(id_staff);
	}
	@Override
	public List<MedicalForm> findAllByPatient(int id_patient) {
		return form.findAllByPatient(id_patient);
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
	public List<MedicalForm> search(boolean isName, boolean isDate, String name, Date date) {
		return form.search(isName, isDate, name, date);
	}

	@Override
	public List<MedicalForm> searchByIDPatient(int id) {
		return form.searchByIDPatient(id);
	}

	@Override
	public List<MedicalForm> findAll1() {
		return form.findAll1();
	}

	@Override
	public void deleteByStaff(List<Integer> list) {
		for (Integer i: list) {
			form.deleteByStaff(i);
		
		}
	}

	@Override
	public void deleteByPatient(List<Integer> list) {
		for (Integer i: list) {
			form.deleteByPatient(i);
		
		}		
	}

	@Override
	public void delete(List<Integer> list) {
		for (Integer i: list) {
			form.delete(i);
		
		}			
	}

	@Override
	public List<MedicalForm> searchByDoctor(boolean isName, boolean isDate, String name, Date date, int id_doctor) {
		return form.searchByDoctor(isName, isDate, name, date,id_doctor);
	}


}
