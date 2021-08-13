package BUS;

import java.util.List;

import DTO.Staff;
import PAGING.Pageble;


public interface IStaffBUS {
	public List<Staff> findAll();
	public int insert(Staff p);
	public void update(Staff p);
	public void delete(List<Integer> list);
	public Staff findOne(int id);
	public Staff searchByUserNameAndPassword(String username,String password);
	public List<Staff> searchByIDOrName(int id,String name);
	public List<Staff> findStaffWithPage(Pageble pageble);
	public Staff searchByNameAndICard(String fullname,String card);


}
