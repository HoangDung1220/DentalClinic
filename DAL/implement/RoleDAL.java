package DAL.implement;

import java.util.List;

import DAL.IRoleDAL;
import DTO.Role;
import Mapper.RoleMapper;

public class RoleDAL extends AbstractDAL<Role> implements IRoleDAL {

	@Override
	public List<Role> findAll() {
		String st ="select *from role";
		return query(st,new RoleMapper());
	}

}
