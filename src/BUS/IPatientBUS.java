package BUS;

import java.util.List;

import DTO.Patient;

public interface IPatientBUS 
{
	public List<Patient> findAll();
	public void insert(Patient p);
	public void update(Patient p);
	public void delete(List<Integer> list);
	public Patient findOne(int id);
	
}
