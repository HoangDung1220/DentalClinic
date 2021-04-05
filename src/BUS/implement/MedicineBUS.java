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
		medicine.findAll();
		return null;
	}

	@Override
	public Medicine findOne(int id) {
		
		return null;
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
	public void delete(int id) {
		medicine.delete(id);
	}

}
