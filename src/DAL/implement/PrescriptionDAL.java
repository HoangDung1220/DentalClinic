package DAL.implement;

import DTO.Prescription;
import Mapper.PrescriptionMapper;

import java.util.List;

import DAL.IPrescriptionDAL;

public class PrescriptionDAL extends AbstractDAL<Prescription> implements IPrescriptionDAL {

	@Override
	public List<Prescription> findAll(int idMedicalForm) {
		String st ="select *from prescription inner join medicine on prescription.id_medicine = medicine.id where prescription.id_medical_form =?";
		return query(st,new PrescriptionMapper(),idMedicalForm);
	}

	@Override
	public Prescription findOne(int id) {
		String st ="select *from prescription inner join medicine on prescription.id_medicine = medicine.id where prescription.id=?";
		List<Prescription> list = query(st,new PrescriptionMapper(),id);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public int insert(Prescription p) {

		String st = "insert into prescription(id_medical_form,id_medicine,quantity,price,usage,note) values (?,?,?,?,?,?)";
		return insert(st,p.getIdMedicalForm(),p.getIdMedicine(),p.getQuantity(),p.getPrice(),p.getUsage(),p.getNote());
	}

	@Override
	public void update(Prescription p) {
		String st ="update prescription set quantity=?,usage=?,note=? where id =?";
		update(st,p.getQuantity(),p.getUsage(),p.getNote(),p.getId());
	}

	@Override
	public void delete(int id) {
		String st ="delete from prescrition where id =?";
		delete (st,id);
	}

}
