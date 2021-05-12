package DAL;

import java.util.List;

import DTO.Prescription;


public interface IPrescriptionDAL {
	public List<Prescription> findAll(int idMedicalForm);
	public Prescription findOne(int id);
	public int insert(Prescription p);
	public void update(Prescription p);
	public void delete(int id);
}
