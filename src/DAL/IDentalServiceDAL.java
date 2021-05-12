package DAL;

import java.util.List;

import DTO.DentalService;

public interface IDentalServiceDAL {
	public List<DentalService> findAll();
	public DentalService findOne(int id);
	public int insert(DentalService p);
	public void update(DentalService p);
	public void delete(int id);
	public List<DentalService> searchByName(String name);
}
