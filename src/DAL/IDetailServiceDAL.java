package DAL;

import java.util.List;

import DTO.DetailService;


public interface IDetailServiceDAL {
	public List<DetailService> findAll(int idMedicalForm);
	public List<DetailService> findAllByIDDental(int id);
	public DetailService findOne(int id);
	public int insert(DetailService p);
	public void update(DetailService p);
	public void delete(int id);
	public void deleteMedicalForm(int id);

}
