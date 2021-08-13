package DAL.implement;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import DAL.IPatientDAL;
import DTO.Patient;
import Mapper.PatientMapper;
import Mapper.StaffMapper;
import PAGING.Pageble;

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
		String st ="update patient set fullname =?,gender=?,birthday=?,phone=?,address=?,icard=?,modified_date=?,modified_by=? where id =?";
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
	@Override
	public Patient findOneByIcard(String icard)
	{
		String st="select * from Patient where iCard=?";
		List<Patient> list =query(st,new PatientMapper(),icard);
		return list.isEmpty()?null:list.get(0);
	}
	@Override
	public List<Patient> searchByNameAndIcard(String fullname, String icard) {
		String st = "select * from patient where fullname = ? and icard = ?";
		return query(st, new PatientMapper(), fullname, icard);
	}

	@Override
	public List<Patient> searchByName(String fullname) {
		String st = "select * from patient where fullname = ?";
		 return query(st, new PatientMapper(), fullname);
	}

	@Override
	public List<Patient> searchByIcard(String icard) {
		String st = "select * from patient where icard = ?";
		return query(st, new PatientMapper(), icard);
	}

	@Override
	public List<Patient> findAllByDate() {
		 String st ="select *from patient where created_date=?";    
			return query(st,new PatientMapper(), new Timestamp(System.currentTimeMillis()));
	}

	@Override
	public List<Patient> findAllPage(Pageble pageble) {
		StringBuilder querry = new StringBuilder();
		
		if ((Integer) pageble.getOffset()!=null && (Integer) pageble.getLimit()!=null) {
			querry.append("select * from");
			querry.append("( SELECT ROW_NUMBER() OVER (ORDER BY (SELECT 0)) as [Count], * FROM patient ) as a where [Count] BETWEEN "+pageble.getOffset()+" and "+ pageble.getLimit());					
			return query(querry.toString(),new PatientMapper());
		}
		else 	
		{	querry.append("select *from patient ");	
			return query(querry.toString(),new PatientMapper());
		}
	}

	@Override
	public List<Patient> findAllPage(Pageble pageble, Date date1, Date date2) {
		StringBuilder querry = new StringBuilder();
		
		if ((Integer) pageble.getOffset()!=null && (Integer) pageble.getLimit()!=null) {
			querry.append("select * from ");
			querry.append("( SELECT ROW_NUMBER() OVER (ORDER BY (SELECT 0)) as [Count], * FROM patient where created_date BETWEEN ? AND ? ) as a where [Count] BETWEEN "+pageble.getOffset()+" AND "+pageble.getLimit());			
			return query(querry.toString(),new PatientMapper(),date1,date2);
		}
		else 	
		{	querry.append("select * from patient where created_date BETWEEN ? AND ?")	;
			return query(querry.toString(),new PatientMapper(),date1,date2);
		}
	}

	@Override
	public List<Patient> findAllPage(Date date1, Date date2) {
		StringBuilder querry = new StringBuilder();
		querry.append("select *from patient  where created_date BETWEEN ? and ? ");
		
			
			return query(querry.toString(),new PatientMapper(),date1,date2);
		
	}
	
}
