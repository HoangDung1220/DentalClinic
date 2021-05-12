package DAL.implement;

import java.util.List;

import DAL.IDetailServiceDAL;
import DTO.DentalService;
import DTO.DetailService;
import Mapper.DetailServiceMapper;

public class DetailServiceDAL extends AbstractDAL<DetailService> implements IDetailServiceDAL{

	@Override
	public List<DetailService> findAll(int idMedicalForm) {
		String st ="select *from detail_service inner join dental_service on detail_service.id_dental_service=dental_service.id where detail_service.id_medical_form=?";
		return query(st,new DetailServiceMapper(),idMedicalForm);
	}

	@Override
	public DetailService findOne(int id) {
		String st ="select *from detail_service inner join dental_service on detail_service.id_dental_service=dental_service.id where detail_service.id=?";
		List<DetailService> list = query(st,new DetailServiceMapper(),id);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public int insert(DetailService p) {
		String st ="insert into detail_service(id_medical_form,id_dental_service,quantity,price) values (?,?,?,?)";
		return insert(st,p.getIdMedicalForm(),p.getIdDentalService(),p.getQuantity(),p.getPrice());
	}

	@Override
	public void update(DetailService p) {
		String st ="update detail_service set quantity=?,price=? where id=?";
		 update(st,p.getQuantity(),p.getPrice(),p.getId());
	}

	@Override
	public void delete(int id) {
		String st ="delete from detail_service where id=?";
		delete(st,id);
	}

}
