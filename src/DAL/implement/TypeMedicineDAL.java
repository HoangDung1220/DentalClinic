package DAL.implement;

import java.util.List;

import DAL.ITypeMedicineDAL;
import DTO.TypeMedicine;
import Mapper.TypeMedicineMapper;

public class TypeMedicineDAL extends AbstractDAL<TypeMedicine> implements ITypeMedicineDAL {

	@Override
	public List<TypeMedicine> findAll() {
		String st = "select *from type_medicine";
		return query(st,new TypeMedicineMapper());
	}

	@Override
	public TypeMedicine findOne(int id) {
	return null;
	}

}
