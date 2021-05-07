package BUS.implement;

import java.util.List;

import BUS.IStaffBUS;
import DAL.IStaffDAL;
import DAL.implement.StaffDAL;
import DTO.Staff;

public class StaffBUS implements IStaffBUS{

	IStaffDAL staff = new StaffDAL();
	@Override
	public List<Staff> findAll() {
		return staff.findAll();
	}

	@Override
	public void insert(Staff p) {
		staff.insert(p);		
	}

	@Override
	public void update(Staff p) {
		staff.update(p);
	}

	@Override
	public void delete(int id) {
		staff.delete(id);
	}

}
