package BUS.implement;

import java.util.List;

import BUS.IPrescriptionBUS;
import DAL.implement.PrescriptionDAL;
import DTO.Prescription;

public class PrescriptionBUS implements IPrescriptionBUS {

	PrescriptionDAL prescription = new PrescriptionDAL();
	
	@Override
	public List<Prescription> findAll(int idMedicalForm) {
		return prescription.findAll(idMedicalForm);
	}

	@Override
	public Prescription findOne(int id) {
		return prescription.findOne(id);
	}

	@Override
	public int insert(Prescription p) {
		return prescription.insert(p);
	}

	@Override
	public void update(Prescription p) {
		prescription.update(p);		
	}

	@Override
	public void delete(List<Integer> listId) {
		for (int i:listId) {
			prescription.delete(i);
		}
	}

}
