package BUS;

import java.util.List;

import DTO.Staff;


public interface IStaffBUS {
	public List<Staff> findAll();
	public void insert(Staff p);
	public void update(Staff p);
	public void delete(int id);

}
