package BUS;

import java.util.List;

import DTO.DetailService;

public interface IDetailServiceBUS {
	public List<DetailService> findAll(int idMedicalForm);
	public DetailService findOne(int id);
	public int insert(DetailService p);
	public void update(DetailService p);
	public void delete(List<Integer> listId);
}
