package BUS.implement;

import java.util.List;

import BUS.IDentalServiceBUS;
import DAL.implement.DentalServiceDAL;
import DTO.DentalService;

public class DentalServiceBUS implements IDentalServiceBUS {

	DentalServiceDAL service = new DentalServiceDAL();
	@Override
	public List<DentalService> findAll() {
		return service.findAll();
	}

	@Override
	public DentalService findOne(int id) {
		// TODO Auto-generated method stub
		return service.findOne(id);
	}

	@Override
	public int insert(DentalService p) {
		// TODO Auto-generated method stub
		return service.insert(p);
	}

	@Override
	public void update(DentalService p) {
		service.update(p);
	}

	@Override
	public void delete(List<Integer> list) {
		// TODO Auto-generated method stub
		for (Integer i:list) {
			service.delete(i);
		}
		
	}

	@Override
	public List<DentalService> searchByName(String name) {
		// TODO Auto-generated method stub
		return service.searchByName(name);
	}

}
