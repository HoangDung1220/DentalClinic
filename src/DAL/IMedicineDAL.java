package DAL;

import java.util.List;

import DTO.Medicine;



public interface IMedicineDAL {
	public List<Medicine> findAll();
	public Medicine findOne(int id);
	public int insert(Medicine p);
	public void update(Medicine p);
	public void delete(int id);
	public List<Medicine> searchByNameAndIDType(String name,int idType);

}
