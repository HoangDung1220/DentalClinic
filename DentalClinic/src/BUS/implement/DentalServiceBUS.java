package BUS.implement;

import java.util.ArrayList;
import java.util.List;

import BUS.IDentalServiceBUS;
import DAL.implement.DentalServiceDAL;
import DTO.DentalService;
import DTO.DetailService;
import PAGING.Pageble;

public class DentalServiceBUS implements IDentalServiceBUS {

	DentalServiceDAL service = new DentalServiceDAL();
	DetailServiceBUS detail = new DetailServiceBUS();
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
		
		for (Integer i:list) {
			List<DetailService> listDetail = detail.findAllByIDDental(i);
			List<Integer> listIdDetail = new ArrayList<Integer>();
			for (DetailService j: listDetail) {
				listIdDetail.add(j.getId());
			}
			detail.delete(listIdDetail);
			service.delete(i);
		}
		
	}

	@Override
	public List<DentalService> searchByName(String name) {
		return service.searchByName(name);
	}

	@Override
	public List<DentalService> findAllWithPage(Pageble pageble) {
		
		return service.findAllWithPage(pageble);
	}

	@Override
	public List<DentalService> searchByName(String name, Pageble pageble) {
				return service.searchByName(name, pageble);
	}

}
