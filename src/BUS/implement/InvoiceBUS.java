package BUS.implement;

import java.util.List;

import BUS.IInvoiceBUS;
import DAL.implement.InvoiceDAL;
import DTO.Invoice;
import DTO.MedicalForm;

public class InvoiceBUS implements IInvoiceBUS {
	
	private InvoiceDAL invoice = new InvoiceDAL();
	private MedicalFormBUS medicalForm = new MedicalFormBUS();
	
	@Override
	public List<Invoice> findAll() {
		// TODO Auto-generated method stub
		return invoice.findAll();
	}

	@Override
	public Invoice findOne(String id) {
		return invoice.findOne(id);
	}

	@Override
	public void Save(Invoice invoice1) {
		invoice.Save(invoice1);
	}

	@Override
	public void Update(Invoice invoice1) {
		
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

	@Override
	public List<Invoice> findAllOderByDate() {
		return invoice.findAllOderByDate();
	}

	@Override
	public int count(int idPatient) {
		int cout =1;
		List<Invoice> invoices = invoice.findAll();
		for (Invoice in : invoices) {
			MedicalForm form = new MedicalForm();
			form = medicalForm.findOne(in.getIdMedicalForm());
			if (form.getIdPatient()==idPatient) {
				cout++;
			}
		}
		return cout;
	}

	
}
