package BUS.implement;

import java.util.List;

import BUS.IPatientBUS;
import DAL.implement.PatientDAL;
import DTO.Patient;

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
	public void delete(int id) {

		patient.delete(id);
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

}
