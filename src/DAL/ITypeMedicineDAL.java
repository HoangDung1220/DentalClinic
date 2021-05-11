package DAL;

import java.util.List;

import DTO.TypeMedicine;

public interface ITypeMedicineDAL {
	public List<TypeMedicine> findAll();
	public TypeMedicine findOne(int id);
}
