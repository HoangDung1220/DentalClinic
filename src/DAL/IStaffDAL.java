package DAL;

import java.util.List;

import DTO.Staff;


public interface IStaffDAL {
	public List<Staff> findAll();
	public Staff findOne(int id);
	public void insert(Staff p);
	public void update(Staff p);
	public void delete(int id);
	

}
