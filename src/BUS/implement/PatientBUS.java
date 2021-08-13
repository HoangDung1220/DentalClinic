package BUS.implement;

import java.sql.Date;
import java.util.List;

import BUS.IPatientBUS;
import DAL.implement.PatientDAL;
import DTO.Patient;
import PAGING.Pageble;

public class PatientBUS implements IPatientBUS{
	
	PatientDAL patient;
	
	public PatientBUS (){
		patient = new PatientDAL();
	}

	@Override
	public List<Patient> findAll() {

		return patient.findAll();
	}

	@Override
	public int insert(Patient p) {
				return patient.insert(p);
	}

	@Override
	public void update(Patient p) {

		
		patient.update(p);
		
	}

	@Override
	public void delete(List<Integer> list) {

		for (int i: list) {
			patient.delete(i);
		}
	}

	@Override
	public Patient findOne(int id) {
		return patient.findOne(id);
	}

	@Override
	public List<Patient> searchByNameAndIcard(String name, String icard) {
		return patient.searchByNameAndIcard(name,icard);
	}

	@Override
	public List<Patient> searchByName(String fullname) {
		return patient.searchByName(fullname);
	}

	@Override
	public List<Patient> searchByIcard(String icard) {
		// TODO Auto-generated method stub
		return patient.searchByIcard(icard);
	}

	@Override
	public List<Patient> findAllByDate() {
		return patient.findAllByDate();
	}

	@Override
	public List<Patient> findAllPaging(Pageble pageble) {
		return patient.findAllPage(pageble);
	}

	@Override
	public List<Patient> findAllPage(Pageble pageble, Date date1, Date date2) {
		return patient.findAllPage(pageble,date1,date2);

	}

	@Override
	public List<Patient> findAllPage(Date date1, Date date2) {
		return patient.findAllPage(date1,date2);
	}

	@Override
	public Patient findOneByIcard(String icard) {
		
		return patient.findOneByIcard(icard);
	}

}
