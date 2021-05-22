package DAL.implement;

import java.util.List;

import DAL.IInvoiceDAL;
import DTO.Invoice;
import Mapper.InvoiceMapper;

public class InvoiceDAL extends AbstractDAL<Invoice> implements IInvoiceDAL {

	@Override
	public List<Invoice> findAll() {
		String st ="select *from invoice inner join staff on invoice.id_staff = staff.id";
		return query(st,new InvoiceMapper());
	}

	@Override
	public Invoice findOne(int id) {
		String st ="select *from invoice inner join staff on invoice.id_staff = staff.id where invoice.id=?";
		List<Invoice> list = query(st,new InvoiceMapper(),id);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public void Save(Invoice invoice1) {
		String st ="insert into invoice(id,id_medical_form,id_staff,total_price_medicine,total_price_service,pay_date,total_price) values(?,?,?,?,?,?,?)";
		insert(st,invoice1.getId(),invoice1.getIdMedicalForm(),invoice1.getIdStaff(),invoice1.getTotalPriceMedicine()
				,invoice1.getTotalPriceService(),invoice1.getPayDate(),invoice1.getTotalPrice());
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
