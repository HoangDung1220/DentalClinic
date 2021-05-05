package DAL;

import java.util.List;

import Mapper.RowMapper;

public interface GenericDAL<T> {
	public  List<T> query(String st,RowMapper<T> rowMapper,Object... paramters);
	public int insert(String st,Object... paramters);
	public void update(String st,Object... paramters);
	public void delete(String st,Object... paramters);
	

}
