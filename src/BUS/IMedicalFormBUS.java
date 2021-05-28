package BUS;

import java.sql.Date;
import java.util.List;

import DTO.MedicalForm;

public interface IMedicalFormBUS {
	public List<MedicalForm> findAll(int id_staff);
	public MedicalForm findOne(int id);
	public int insert(MedicalForm p);
	public void update(MedicalForm p);
	public void delete(int id);
	public List<MedicalForm> search(boolean isName,boolean isDate, String name,Date date);
	public List<MedicalForm> searchByIDPatient(int id);


}
