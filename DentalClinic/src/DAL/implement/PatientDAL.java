  
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
	public void insert(Patient p) {
		String st ="insert into patient(fullname,gender,birthday,phone,address,icard,created_by,created_date,modified_by,modified_date,status) values (?,?,?,?,?,?,?,?,?,?,?)";
	    insert(st,p.getFullname(),p.getGender(),p.getBirthday(),p.getPhone(),p.getAddress(),
	    		p.getiCard(),p.getCreatedBy(),p.getCreatedDate(),p.getModifiedBy(),p.getModifiedDate(),p.getStatus());
	//createdby
		
	
	}

	@Override
	public void update(Patient p) {
		String st ="update patient  set fullname =?,gender=?,birthday=?,phone=?,address=?,icard=?,created_by=?,created_date=?,modified_date=?,modified_by=?,status=? where id =?";
		update(st,p.getFullname(),p.getGender(),p.getBirthday(),p.getPhone(),p.getAddress(),p.getiCard(),p.getCreatedBy(),p.getCreatedDate(),p.getModifiedDate(),p.getModifiedBy(),p.getStatus(),p.getId());	
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