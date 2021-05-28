package BUS;

import java.util.List;

import DTO.Invoice;

public interface IInvoiceBUS {
	public List<Invoice> findAll();
	public Invoice findOne(int id);
	public void Save(Invoice invoice);
	public void Update(Invoice invoice);
	public void Delete(int id);
	public void printf(String id1);
	public Invoice findOneByIdMedical(int id);
}
