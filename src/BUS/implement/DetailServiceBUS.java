package BUS.implement;

import java.util.List;

import BUS.IDetailServiceBUS;
import DAL.implement.DetailServiceDAL;
import DTO.DetailService;

public class DetailServiceBUS implements IDetailServiceBUS{

	DetailServiceDAL detailService = new DetailServiceDAL();
	@Override
	public List<DetailService> findAll(int idMedicalForm) {
		return detailService.findAll(idMedicalForm);
	}

	@Override
	public DetailService findOne(int id) {
		return detailService.findOne(id);
	}

	@Override
	public int insert(DetailService p) {
		return detailService.insert(p);
	}

	@Override
	public void update(DetailService p) {
		detailService.update(p);
	}

	@Override
	public void delete(List<Integer> listId) {
		for (int id :listId) {
			detailService.delete(id);		
		}
	}

}
