package BUS.implement;

import java.util.List;

import BUS.IMedicalFormBUS;
import DTO.MedicalForm;

public class MedicalFormBUS implements IMedicalFormBUS{

	MedicalFormBUS form = new MedicalFormBUS();
	@Override
	public List<MedicalForm> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalForm findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MedicalForm p) {
		// TODO Auto-generated method stub
		return form.insert(p);
	}

	@Override
	public void update(MedicalForm p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
