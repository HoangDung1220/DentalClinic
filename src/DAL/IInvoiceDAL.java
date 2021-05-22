package DAL;

import java.util.List;

import DTO.Invoice;

public interface IInvoiceDAL {
	public List<Invoice> findAll();
	public Invoice findOne(int id);
	public void Save(Invoice invoice);
	public void Update(Invoice invoice);
	public void Delete(int id);

}
