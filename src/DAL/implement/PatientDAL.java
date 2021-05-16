package DAL.implement;

import java.util.List;

import DAL.IPatientDAL;
import DTO.Patient;
import Mapper.PatientMapper;

public class PatientDAL extends AbstractDAL<Patient> implements IPatientDAL{

	@Override
	public List<Patient> findAll() {
        String st ="select *from patient";    
		return query(st,new PatientMapper());
	}

	@Override
	public int insert(Patient p) {
		String st ="insert into patient(fullname,gender,phone,address,birthday,icard,created_date,created_by) values (?,?,?,?,?,?,?,?)";
	   return insert(st,p.getFullname(),p.getGender(),p.getPhone(),p.getAddress(),p.getBirthday()
	    		,p.getiCard(),p.getCreatedDate(),p.getCreatedBy());
	//createdby
		
	
	}

	@Override
	public void update(Patient p) {
		String st ="update patient set fullname =?,gender=?,birthday=?,phone=?,address=?,icard=?,modified_date=?,modified_by=?where id =?";
		update(st,p.getFullname(),p.getGender(),p.getBirthday(),p.getPhone(),p.getAddress(),p.getiCard(),p.getModifiedDate(),p.getModifiedBy(),p.getId());	
	}

	@Override
	public void delete(int id) {
		String st ="delete from patient where id =?";
		delete(st,id);
		
		
	}

	@Override
	public Patient findOne(int id) {
        String st ="select *from Patient where id=?";    
        List<Patient> list = query(st,new PatientMapper(),id);
	    return list.isEmpty()?null:list.get(0);
	}

}
