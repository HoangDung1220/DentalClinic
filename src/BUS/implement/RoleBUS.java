package BUS.implement;

import java.util.List;

import BUS.IRoleBUS;
import DAL.implement.RoleDAL;
import DTO.Role;

public class RoleBUS implements IRoleBUS{
	RoleDAL role = new RoleDAL();
	@Override
	public List<Role> findAll() {
		return role.findAll();
	}

}
