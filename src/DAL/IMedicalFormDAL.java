package DAL;

import java.sql.Date;
import java.util.List;

import DTO.MedicalForm;

public interface IMedicalFormDAL {
	public List<MedicalForm> findAll(int id_staff);
	public List<MedicalForm> findAll1();
	public MedicalForm findOne(int id);
	public int insert(MedicalForm p);
	public void update(MedicalForm p);
	public void delete(int id);
	public void deleteByStaff(int id);
	public void deleteByPatient(int id);
	public List<MedicalForm> search(boolean isName,boolean isDate, String name,Date date);
	public List<MedicalForm> searchByDoctor(boolean isName,boolean isDate, String name,Date date,int id_doctor);
	public List<MedicalForm> searchByIDPatient(int id);

}
