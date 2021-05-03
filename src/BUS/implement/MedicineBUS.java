package BUS.implement;

import java.util.List;

import BUS.IMedicineBUS;
import DAL.IMedicineDAL;
import DAL.implement.MedicineDAL;
import DTO.Medicine;

public class MedicineBUS implements IMedicineBUS{
	
	IMedicineDAL medicine = new MedicineDAL();

	@Override
	public List<Medicine> findAll() {
		return medicine.findAll();
		
	}

	@Override
	public Medicine findOne(int id) {
		
		return medicine.findOne(id);
	}

	@Override
	public void insert(Medicine p) {
		medicine.insert(p);
	}

	@Override
	public void update(Medicine p) {
		medicine.update(p);
	}

	@Override
	public void delete(List<Integer> list) {
		for (int id : list)
		medicine.delete(id);
	}

}
