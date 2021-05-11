package BUS;

import java.sql.Date;
import java.util.List;

import DTO.MedicalForm;

public interface IMedicalFormBUS {
	public List<MedicalForm> findAll();
	public MedicalForm findOne(int id);
	public int insert(MedicalForm p);
	public void update(MedicalForm p);
	public void delete(int id);
	public List<MedicalForm> search(boolean isName,boolean isDate, String name,Date date);

}
