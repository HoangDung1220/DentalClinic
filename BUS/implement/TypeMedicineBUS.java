package BUS.implement;

import java.util.List;

import BUS.ITypeMedicineBUS;
import DAL.ITypeMedicineDAL;
import DAL.implement.TypeMedicineDAL;
import DTO.TypeMedicine;

public class TypeMedicineBUS implements ITypeMedicineBUS{
	ITypeMedicineDAL type = new TypeMedicineDAL();
	@Override
	public List<TypeMedicine> findAll() {
		// TODO Auto-generated method stub
		return type.findAll();
	}

}
