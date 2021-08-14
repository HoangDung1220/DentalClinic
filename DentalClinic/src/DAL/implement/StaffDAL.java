package DAL.implement;

import java.sql.Timestamp;
import java.util.List;

import Constant.SystemConstant;
import DAL.IStaffDAL;
import DTO.Staff;
import Mapper.StaffMapper;
import PAGING.Pageble;

public class StaffDAL extends AbstractDAL<Staff> implements IStaffDAL {

	@Override
	public List<Staff> findAll() {
		 String st ="select *from staff inner join role on staff.id_role=role.id ";    
			return query(st,new StaffMapper());
	}

	@Override
	public Staff findOne(int id1) {
		 String st ="select *from staff inner join role on staff.id_role=role.id where staff.id =?";
		 List<Staff> list = query(st, new StaffMapper(),id1);
		 return list.isEmpty()?null:list.get(0);

	}

	@Override
	public int insert(Staff p) {
		StringBuilder st = new StringBuilder(); 
		p.setCreatedBy(SystemConstant.staff.getFullname());
		p.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		p.setPassword("00000");
		st.append("insert into staff(fullname,gender,birthday,phone,address,icard,email");
		st.append(",date_start_work,id_role,password,created_date,created_by)");
		st.append(" values (?,?,?,?,?,?,?,?,?,?,?,?)");
		
	    return insert(st.toString(),p.getFullname(),p.getGender(),p.getBirthday(),p.getPhone(),p.getAddress()
				,p.getiCard(),p.getEmail(),p.getDateStartWork(),p.getIdRole(),p.getPassword(),p.getCreatedDate(),p.getCreatedBy());
	
		
	}

	@Override
	public void update(Staff p) {
		StringBuilder st = new StringBuilder();
		p.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		p.setModifiedBy(SystemConstant.staff.getFullname());
		st.append("update staff set fullname =?,gender=?,birthday=?,phone=?,address=?,");
		st.append("icard=?,email=?,date_start_work=?,id_role=?,modified_date=?,modified_by=?,username=?,password=? where id =?");
		update(st.toString(),p.getFullname(),p.getGender(),p.getBirthday(),p.getPhone(),p.getAddress()
				,p.getiCard(),p.getEmail(),p.getDateStartWork(),p.getIdRole(),p.getModifiedDate(),p.getModifiedBy(),p.getUsername(),p.getPassword(),p.getId());	
	}

	@Override
	public void delete(int id) {
		String st ="delete from staff where id =?";
		delete(st,id);
		
	}

	@Override
	public Staff searchByUserNameAndPassword(String username, String password) {
		 String st ="select *from staff inner join role on staff.id_role=role.id where staff.username=? and staff.password=? ";    
		 List<Staff> list = query(st,new StaffMapper(),username,password);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public List<Staff> searchByIDOrName(int id, String name) {
		List<Staff> listStaff = null;
		 StringBuilder st = new StringBuilder("select *from staff inner join role on staff.id_role=role.id ");
		
		if (String.valueOf(id)!=null || name!=null) {
			 if (id!=-1 ){
				 st.append("where staff.id like '%"+String.valueOf(id)+"%'");
			 } else
			 if (name!=null ){
				 st.append("where staff.fullname like '%"+name+"%'");
			 }
		}
		
		 listStaff=query(st.toString(),new StaffMapper());
		 return listStaff;
	}

	

	@Override
	public List<Staff> findStaffWithPage(Pageble pageble) {
		StringBuilder querry = new StringBuilder();
		int total=pageble.getOffset()+pageble.getLimit();
		if ((Integer) pageble.getOffset()!=null && (Integer) pageble.getLimit()!=null) {
			querry.append("select * from ( SELECT ROW_NUMBER() OVER (ORDER BY (SELECT 0)) as [Count], * FROM staff ) as a inner join role on a.id_role=role.id"
					      + "WHERE [Count] BETWEEN "+ pageble.getOffset()+ " and " +  total );
			return query(querry.toString(),new StaffMapper());
		}
		else 	
		{	querry.append("select *from staff inner join role on staff.id_role=role.id ");	
			return query(querry.toString(),new StaffMapper());
		}
		
	}

}
