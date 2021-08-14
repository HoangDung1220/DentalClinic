package BUS;

import java.sql.Date;
import java.util.List;

import DTO.MedicalForm;

public interface IMedicalFormBUS {
	public List<MedicalForm> findAll(int id_staff);
	public List<MedicalForm> findAllByPatient(int id_patient);
	public MedicalForm findOne(int id);
	public int insert(MedicalForm p);
	public void update(MedicalForm p);
	public void delete(List<Integer> list);
	public void deleteByStaff(List<Integer> list);
	public void deleteByPatient(List<Integer> list);
	public List<MedicalForm> search(boolean isName,boolean isDate, String name,Date date);
	public List<MedicalForm> searchByDoctor(boolean isName,boolean isDate, String name,Date date,int id_doctor);
	public List<MedicalForm> searchByIDPatient(int id);
	public List<MedicalForm> findAll1();



}
