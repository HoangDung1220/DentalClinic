package BUS;

import java.util.List;

import DTO.Invoice;

public interface IInvoiceBUS {
	public List<Invoice> findAll();
	public List<Invoice> findAllOderByDate();
	public Invoice findOne(String id);
	public void Save(Invoice invoice);
	public void Update(Invoice invoice);
	public void Delete(String id);
	public void printf(String id1);
	public Invoice findOneByIdMedical(int id);
	public int count (int idPatient);


}
