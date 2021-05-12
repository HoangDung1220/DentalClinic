package DAL.implement;

import java.util.List;

import DAL.IMedicineDAL;
import DTO.Medicine;
import Mapper.MedicineMapper;

public class MedicineDAL extends AbstractDAL<Medicine> implements IMedicineDAL{

	@Override
	public List<Medicine> findAll() {
		String st ="select *from medicine inner join type_medicine where medicine.id_typemedicine = type_medicine.id";
		return query(st,new MedicineMapper());
	}

	@Override
	public Medicine findOne(int id) {
		String st ="select *from medicine inner join type_medicine on medicine.id_typemedicine = type_medicine.id where medicine.id=?";
	    List<Medicine> list = query(st,new MedicineMapper(),id);
	    return list.isEmpty()?null:list.get(0);
	}

	@Override
	public int insert(Medicine p) {
		
		String st = "insert into medicine(name_medicine,code_medicine,id_typemedicine,price,unit,quantity) values (?,?,?,?,?,?)";
				return insert(st,p.getNameMedicine(),p.getCodeMedicine(),p.getIdTypeMedicine(),p.getPrice(),p.getUnit(),p.getQuantity());
			
	}

	@Override
	public void update(Medicine p) {
		String st = "update medicine set name_medicine=?,code_medicine=?,id_typemedicine=?,unit=?,price=?,quantity=? where id=?";
		update(st,p.getNameMedicine(),p.getCodeMedicine(),p.getIdTypeMedicine(),p.getUnit(),p.getPrice(),p.getQuantity(),p.getId());
	}

	@Override
	public void delete(int id) {

		String st ="delete from medicine where id=?";
		delete(st,id);
	}

	@Override
	public List<Medicine> searchByNameAndIDType(String name, int idType) {
		StringBuilder st = new StringBuilder("select *from medicine inner join type_medicine on medicine.id_typemedicine = type_medicine.id");
		if (idType != 0) {
			st.append(" where type_medicine.id = '"+idType+"' ");
			st.append("and medicine.name_medicine like '%"+name+"%'");

		} else 
		st.append(" where medicine.name_medicine like '%"+name+"%'");
		List<Medicine> list = query(st.toString(),new MedicineMapper());
		return list;
	}

}
