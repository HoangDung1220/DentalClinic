package BUS;

import java.util.List;

import DTO.MedicalForm;

public interface IMedicalFormBUS {
	public List<MedicalForm> findAll();
	public MedicalForm findOne(int id);
	public int insert(MedicalForm p);
	public void update(MedicalForm p);
	public void delete(int id);
}
