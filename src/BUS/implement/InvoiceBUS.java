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
		return null;
	}

	@Override
	public Invoice findOne(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
