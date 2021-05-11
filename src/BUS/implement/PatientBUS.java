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
	public void insert(Patient p) {
				patient.insert(p);
	}

	@Override
	public void update(Patient p) {

		
		patient.update(p);
		
	}

	@Override
	public void delete(int id) {

		patient.delete(id);
	}

}
