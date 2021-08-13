package DAL;

import java.util.List;


import DTO.Staff;
import PAGING.Pageble;


public interface IStaffDAL {
	public List<Staff> findAll();
	public Staff findOne(int id);
	public int insert(Staff p);
	public void update(Staff p);
	public void delete(int id);
	public Staff searchByUserNameAndPassword(String username,String password);
	public List<Staff> searchByIDOrName(int id,String name);
	public List<Staff> findStaffWithPage(Pageble pageble);
	public Staff searchByNameAndICard(String fullname,String card);


	

}
