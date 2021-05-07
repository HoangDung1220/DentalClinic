package BUS;

import java.util.List;

import DTO.DentalService;


public interface IDentalServiceBUS {
	public List<DentalService> findAll();
	public DentalService findOne(int id);
	public int insert(DentalService p);
	public void update(DentalService p);
	public void delete(List<Integer> list);
	public List<DentalService> searchByName(String name);
}
