package BUS;

import java.util.List;

import BUS.impl.IPatientBUS;
import DAL.AbstractDAL;
import DAL.PatientDAL;
import DTO.Patient;

public class PatientBUS extends AbstractDAL<Patient> implements IPatientBUS{
	
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

		Patient pi = patient.findOne(p.getId());
		patient.update(pi);
		
	}

	@Override
	public void delete(int id) {

		patient.delete(id);
	}

}
