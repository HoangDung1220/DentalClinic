package DAL;

import java.util.List;

import DTO.DentalService;


public interface IDentalService {
	public List<DentalService> findAll();
	public DentalService findOne(int id);
	public void insert(DentalService p);
	public void update(DentalService p);
	public void delete(int id);

}
