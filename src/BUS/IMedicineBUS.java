package BUS;

import java.util.List;

import DTO.Medicine;

public interface IMedicineBUS  {
	public List<Medicine> findAll();
	public Medicine findOne(int id);
	public void insert(Medicine p);
	public void update(Medicine p);
	public void delete(List<Integer> list);


}
