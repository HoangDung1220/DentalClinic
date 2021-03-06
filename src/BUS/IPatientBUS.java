package BUS;

import java.sql.Date;
import java.util.List;

import DTO.Patient;
import PAGING.Pageble;

public interface IPatientBUS {
	public List<Patient> findAll();
	public List<Patient> findAllByDate();
	public Patient findOne(int id);
	public int insert(Patient p);
	public void update(Patient p);
	public void delete(List<Integer> id);
	public List<Patient> searchByNameAndIcard(String fullname, String icard);
	public List<Patient> searchByName(String fullname);
	public List<Patient> searchByIcard(String icard);
	public List<Patient> findAllPaging(Pageble pageble);
	public List<Patient> findAllPage(Pageble pageble, Date date1, Date date2);
	public List<Patient> findAllPage(Date date1, Date date2) ;
	public Patient findOneByIcard(String icard);


}
