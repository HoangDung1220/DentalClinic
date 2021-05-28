package DAL;

import java.util.List;

import Mapper.RowMapper;

public interface GenericDAL<T>
{
	public List<T> query(String st, RowMapper<T> rowMapper, Object...parameters);
	public void insert(String st, Object...parameters);
	public void update(String st, Object...parameters);
	public void delete(String st, Object...parameters);
}
	

}
