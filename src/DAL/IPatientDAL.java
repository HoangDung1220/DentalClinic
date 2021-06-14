package DAL;

import java.util.List;

import DTO.Patient;

public interface IPatientDAL  {
	public List<Patient> findAll();
	public List<Patient> findAllByDate();
	public Patient findOne(int id);
	public int insert(Patient p);
	public void update(Patient p);
	public void delete(int id);
	public List<Patient> searchByNameAndIcard(String fullname, String icard);
	public List<Patient> searchByName(String fullname);
	public List<Patient> searchByIcard(String icard);

}
