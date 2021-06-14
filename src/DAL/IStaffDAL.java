package DAL;

import java.util.List;

import DTO.Staff;


public interface IStaffDAL {
	public List<Staff> findAll();
	public Staff findOne(int id);
	public int insert(Staff p);
	public void update(Staff p);
	public void delete(int id);
	public Staff searchByUserNameAndPassword(String username,String password);
	public List<Staff> searchByIDOrName(int id,String name);

	

}
