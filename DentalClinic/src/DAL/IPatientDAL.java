package DAL;

import java.util.List;

import DTO.Patient;

public interface IPatientDAL  {
	public List<Patient> findAll();
	public Patient findOne(int id);
	public void insert(Patient p);
	public void update(Patient p);
	public void delete(int id);
	

}

