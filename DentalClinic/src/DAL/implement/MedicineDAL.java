package DAL.implement;

import java.util.List;

import DAL.IMedicineDAL;
import DTO.Medicine;
import Mapper.DentalServiceMapper;
import Mapper.MedicineMapper;
import PAGING.Pageble;

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
			st.append(" where type_medicine.id = "+idType);
			st.append(" and medicine.name_medicine like '%"+name+"%'");

		} else 
		st.append(" where medicine.name_medicine like '%"+name+"%'");
		List<Medicine> list = query(st.toString(),new MedicineMapper());
		return list;
	}

	@Override
	public List<Medicine> findAll(Pageble pageable) {
		StringBuilder querry = new StringBuilder();
		
		if ((Integer) pageable.getOffset()!=null && (Integer) pageable.getLimit()!=null) {
			querry.append("select * from ( SELECT ROW_NUMBER() OVER (ORDER BY (SELECT 0)) as [Count], * FROM medicine ) as a inner  join type_medicine on a.id_typemedicine = type_medicine.id " 
					+"WHERE [Count] BETWEEN " +pageable.getOffset()+" and "+ pageable.getLimit());
			return query(querry.toString(),new MedicineMapper());
		}
		else 	
		{	querry.append("select * from medicine inner join type_medicine where medicine.id_typemedicine = type_medicine.id")	;
			return query(querry.toString(),new MedicineMapper());
		}
	}

	@Override
	public List<Medicine> searchByNameAndIDType(String name, int idType, Pageble pageable) {
		StringBuilder querry = new StringBuilder();
		String str="(SELECT ROW_NUMBER() OVER (ORDER BY (SELECT 0)) as [Count], * FROM medicine";
		String cndId=" id_typemedicine = "+idType;
		String cndName=" name_medicine like '%"+name+"%'";
		String inner=" ) as a inner  join type_medicine on a.id_typemedicine = type_medicine.id ";
		String cnd="";
		if(idType!=0)
		{
			cnd=" where "+cndId+" and "+cndName;
		}
		else cnd=" where"+cndName;
		if ((Integer) pageable.getOffset()!=null && (Integer) pageable.getLimit()!=null ) {
			querry.append(" select * from" + str + cnd + inner 
					      + " WHERE [Count] BETWEEN " +pageable.getOffset()+" and "+ pageable.getLimit() );
			return query(querry.toString(),new MedicineMapper());
		}

		else
		{   querry.append("select * from medicine inner join type_medicine on medicine.id_typemedicine = type_medicine.id "+cnd);
			return query(querry.toString(),new MedicineMapper());
		}
	}

}
