package BUS.implement;

import java.util.ArrayList;
import java.util.List;

import BUS.IMedicineBUS;
import DAL.IMedicineDAL;
import DAL.implement.MedicineDAL;
import DTO.DetailService;
import DTO.Medicine;
import DTO.Prescription;

public class MedicineBUS implements IMedicineBUS{
	
	IMedicineDAL medicine = new MedicineDAL();
	PrescriptionBUS prescription = new PrescriptionBUS();

	@Override
	public List<Medicine> findAll() {
		return medicine.findAll();
		
	}

	@Override
	public Medicine findOne(int id) {
		
		return medicine.findOne(id);
	}

	@Override
	public int insert(Medicine p) {
		return medicine.insert(p);
	}

	@Override
	public void update(Medicine p) {
		medicine.update(p);
	}

	@Override
	public void delete(List<Integer> list) {
		
		for (Integer i:list) {
			List<Prescription> listDetail = prescription.findByIDMedicine(i);
			List<Integer> listIdDetail = new ArrayList<Integer>();
			for (Prescription j: listDetail) {
				listIdDetail.add(j.getId());
			}
			prescription.delete(listIdDetail);
			medicine.delete(i);
		}
	}

	@Override
	public List<Medicine> searchByNameAndIDType(String name, int idType) {
		return medicine.searchByNameAndIDType(name, idType);
	}

}
