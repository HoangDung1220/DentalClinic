package BUS.implement;

import java.util.List;

import BUS.IInvoiceBUS;
import DAL.implement.InvoiceDAL;
import DTO.Invoice;

public class InvoiceBUS implements IInvoiceBUS {
	
	private InvoiceDAL invoice = new InvoiceDAL();
	@Override
	public List<Invoice> findAll() {
		// TODO Auto-generated method stub
		return invoice.findAll();
	}

	@Override
	public Invoice findOne(String id) {
		// TODO Auto-generated method stub
		return invoice.findOne(id);
	}

	@Override
	public void Save(Invoice invoice1) {
		invoice.Save(invoice1);
	}

	@Override
	public void Update(Invoice invoice1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(String id) {
		invoice.Delete(id);
		
	}

	@Override
	public void printf(String id1) {
		invoice.printf(id1);
	}

	@Override
	public Invoice findOneByIdMedical(int id) {
		return invoice.fidOneByIdMedical(id);
	}

	
}
