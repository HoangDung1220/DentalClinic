package DAL.implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DAL.GenericDAL;
import Mapper.RowMapper;

public class AbstractDAL<T> implements GenericDAL<T>{
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			String url ="jdbc:mysql://localhost:3306/dental_clinic";
			String username ="root";
			String password ="120301200201";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	      catch (SQLException e) {
	     	e.printStackTrace();
	}
		
		return conn;
	}

	
	public void setParamters(PreparedStatement ppst,Object... paramters) {
		try {
		for (int i=0;i<paramters.length;i++) {
			if (paramters[i] instanceof String) {
				
					ppst.setString(i+1, (String) paramters[i]);
			}
			if (paramters[i] instanceof Float) {
				
				ppst.setFloat(i+1, (float) paramters[i]);
		}
			if (paramters[i] instanceof Integer) {
				
				ppst.setInt(i+1, (int) paramters[i]);
		}
			if (paramters[i] instanceof Byte) {
				
				ppst.setByte(i+1, (byte) paramters[i]);
		}
			if (paramters[i] instanceof Timestamp) {
				
				ppst.setTimestamp(i+1, (Timestamp) paramters[i]);
		}
			if (paramters[i] instanceof Date) {
				
				ppst.setDate(i+1, (Date) paramters[i]);
		}
			if (paramters[i] instanceof Double) {
				
				ppst.setDouble(i+1, (Double) paramters[i]);
		}
			
		}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		
	}
	
	@Override
	public List<T> query(String st, RowMapper<T> rowMapper, Object... paramters)  {

		PreparedStatement ppst = null;
		ResultSet rs = null;
		Connection conn = null;
		List<T> list = new ArrayList<T>();
		try {
			
			conn = getConnection();
			conn.setAutoCommit(false);
			ppst = conn.prepareStatement(st);
			setParamters(ppst,paramters);
			rs = ppst.executeQuery();
			while (rs.next()) {
				list.add(rowMapper.mapRow(rs));
			}
			conn.commit();
		} catch (SQLException e) {
			if (conn!=null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
		finally {
			try {
			if (conn!=null) {
				
					conn.close();
			}
			
			if (ppst!=null) {
				ppst.close();
			}
			
			if (rs!=null) {
				rs.close();
			}
				} catch (SQLException e) {
					
					e.printStackTrace();
			}
		}
		
		return list;
	}

	
	@Override
	public void insert(String st, Object... paramters) {
		Connection conn = null;
		PreparedStatement ppst = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ppst = conn.prepareStatement(st);
			setParamters(ppst,paramters);
			ppst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn!= null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		finally {
			try {
			if (conn!=null) {
				
					conn.close();
			}
			
			if (ppst!=null) {
				ppst.close();
			}
			
				} catch (SQLException e) {
					
					e.printStackTrace();
			}
		}
		
	}

	@Override
	public void update(String st, Object... paramters) {
		Connection conn = null;
		PreparedStatement ppst = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ppst = conn.prepareStatement(st);
			setParamters(ppst,paramters);
			ppst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn!= null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		finally {
			try {
			if (conn!=null) {
				
					conn.close();
			}
			
			if (ppst!=null) {
				ppst.close();
			}
			
				} catch (SQLException e) {
					
					e.printStackTrace();
			}
		}

		
	}

	@Override
	public void delete(String st, Object... paramters) {
		Connection conn = null;
		PreparedStatement ppst = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ppst = conn.prepareStatement(st);
			setParamters(ppst,paramters);
			ppst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn!= null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		finally {
			try {
			if (conn!=null) {
				
					conn.close();
			}
			
			if (ppst!=null) {
				ppst.close();
			}
			
				} catch (SQLException e) {
					
					e.printStackTrace();
			}
		}		
	}
	
	

}
