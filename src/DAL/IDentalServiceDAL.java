package DAL;

import java.util.List;

import DTO.DentalService;
import PAGING.Pageble;

public interface IDentalServiceDAL {
	public List<DentalService> findAll();
	public DentalService findOne(int id);
	public int insert(DentalService p);
	public void update(DentalService p);
	public void delete(int id);
	public List<DentalService> searchByName(String name);
	public List<DentalService> findAllWithPage(Pageble pageble);
	public List<DentalService> searchByName(String name,Pageble pageble);
}
