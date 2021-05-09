package DAL.implement;

import java.util.List;

import DAL.IDentalServiceDAL;
import DTO.DentalService;
import Mapper.DentalServiceMapper;

public class DentalServiceDAL extends AbstractDAL<DentalService> implements IDentalServiceDAL {

	@Override
	public List<DentalService> findAll() {
		String st ="select *from dental_service";
		return query(st,new DentalServiceMapper());
	}

	@Override
	public DentalService findOne(int id) {
		String st ="select *from dental_service where id=?";
		List<DentalService> list = query(st,new DentalServiceMapper(),id);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public int insert(DentalService p) {
		String st ="insert into dental_service(name_service,unit,quantity,warranty,price) values (?,?,?,?,?)";
		return insert(st,p.getNameService(),p.getUnit(),p.getQuantity(),p.getWarranty(),p.getPrice());
	}

	@Override
	public void update(DentalService p) {
		String st ="update dental_service set name_service=?,unit=?,quantity=?,warranty=?,price=? where id =?";
		update(st,p.getNameService(),p.getUnit(),p.getQuantity(),p.getWarranty(),p.getPrice(),p.getId());
	}

	@Override
	public void delete(int id) {
		String st ="delete from dental_service where id=? ";
		delete(st,id);
	}

	@Override
	public List<DentalService> searchByName(String name) {
		String st ="select *from dental_service where name_service like '%"+name+"%' ";
		return query(st,new DentalServiceMapper());
	}

}
