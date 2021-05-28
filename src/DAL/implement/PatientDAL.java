package DAL.implement;

import java.sql.Timestamp;
import java.util.List;

import DAL.IPatientDAL;
import DTO.Patient;
import Mapper.PatientMapper;

public class PatientDAL extends AbstractDAL<Patient> implements IPatientDAL
 {

	@Override
	public List<Patient> findAll() {
		String st = "select * from patient";
		return query(st, new PatientMapper());
		
	}

	@Override
	public Patient findOne(int id1) 
	{
		String st = "select * from patient where id = ?";
		List<Patient> list = query(st, new PatientMapper(), id1);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public void insert(Patient p) {
		StringBuilder st = new StringBuilder(); 
		p.setCreatedBy("Nga Quynh");
		p.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		p.setStatus(1);
		
		st.append("insert into patient(id,fullname,gender,birthday,phone,address,icard");
		st.append(",created_by,created_date,modified_by,modified_date,status)");
		st.append(" values (?,?,?,?,?,?,?,?,?,?,?,?)");
		
	    insert(st.toString(),p.getiCard(),p.getFullname(),p.getGender(),p.getBirthday(),p.getPhone(),p.getAddress()
				,p.getiCard(),p.getCreatedDate(),p.getCreatedBy(),p.getModifiedBy(), p.getModifiedDate(), p.getStatus());
	    
	}

	@Override
	public void update(Patient p) {
		StringBuilder st = new StringBuilder();
		p.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		p.setModifiedBy("NV001");
		p.setStatus(0);
		st.append("update patient set fullname =?,gender=?,birthday=?,phone=?,address=?,");
		st.append("icard=?,modified_date=?,modified_by=? where id =?");
		update(st.toString(),p.getFullname(),p.getGender(),p.getBirthday(),p.getPhone(),p.getAddress()
				,p.getiCard(), p.getModifiedDate(),p.getModifiedBy(), p.getId(), p.getStatus());
	}

	@Override
	public void delete(int id) {
		String st = "delete from patient where id = ?";
		delete(st, id);
	}
	
}
