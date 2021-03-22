package DAL;

import java.util.List;

import DAL.impl.IPatientDAL;
import DTO.Patient;
import Mapper.PatientMapper;

public class PatientDAL extends AbstractDAL<Patient> implements IPatientDAL{

	@Override
	public List<Patient> findAll() {
        String st ="select *from Patient";    
		return query(st,new PatientMapper());
	}

	@Override
	public void insert(Patient p) {
		String st ="insert into patient(fullname,gender,phone,address,icard,created_by,status) values (?,?,?,?,?,?,?)";
	    insert(st,p.getFullname(),p.getGender(),p.getPhone(),p.getAddress(),p.getiCard(),p.getCreatedBy(),p.getStatus());
	
		
	
	}

	@Override
	public void update(Patient p) {
		String st ="update patient set fullname =?,gender=?,birthday=?,phone=?,address=?,icard=?,created_by=?,created_date=?,status=? where id =?";
		update(st,p.getFullname(),p.getGender(),p.getBirthday(),p.getPhone(),p.getAddress(),p.getiCard(),p.getCreatedBy(),p.getCreatedDate(),p.getStatus(),p.getId());	
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
