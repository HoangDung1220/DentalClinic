package Mapper;

import java.sql.ResultSet;

import DTO.AccoutLogin;

public class AccountMapper implements RowMapper<AccoutLogin>{

	@Override
	public AccoutLogin mapRow(ResultSet rs) {
		AccoutLogin accout = new AccoutLogin();
		
		return null;
	}

}
