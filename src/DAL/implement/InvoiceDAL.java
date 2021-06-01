package DAL.implement;

import java.util.List;

import DAL.IInvoiceDAL;
import DTO.Invoice;
import Mapper.InvoiceMapper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class InvoiceDAL extends AbstractDAL<Invoice> implements IInvoiceDAL {

	@Override
	public List<Invoice> findAll() {
		StringBuilder st = new StringBuilder("SELECT *FROM invoice inner join staff ON invoice.id_staff = staff.id ");
		return query(st.toString(),new InvoiceMapper());
	}

	@Override
	public Invoice findOne(String id) {
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

	@Override
	public void printf(String id1) {
		try {
			JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Hoang Dung\\eclipse-workspace\\Dental_Clinic_Project\\src\\GUI\\test.jrxml");
			StringBuilder st = new StringBuilder("SELECT *FROM invoice inner join staff ON invoice.id_staff = staff.id ");
			st.append("inner join medical_form ON invoice.id_medical_form = medical_form.id ");
			st.append("inner join patient ON medical_form.id_patient = patient.id ");
			st.append("inner join detail_service ON medical_form.id = detail_service.id_medical_form ");
			st.append("inner join dental_service ON dental_service.id = detail_service.id_dental_service ");
			st.append("WHERE invoice.id = '"+id1+"'");
			JRDesignQuery updateQuery = new JRDesignQuery();
			updateQuery.setText(st.toString());
			jdesign.setQuery(updateQuery);
			JasperReport Jreport = JasperCompileManager.compileReport(jdesign);
			JasperPrint Jprint =JasperFillManager.fillReport(Jreport, null,getConnection());
			JasperViewer.viewReport(Jprint,false);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Invoice fidOneByIdMedical(int id) {
		StringBuilder st =new StringBuilder("select *from invoice inner join medical_form ON invoice.id_medical_form = medical_form.id ");
		st.append("inner join patient ON medical_form.id_patient = patient.id where invoice.id_medical_form=?");
		List<Invoice> list = query(st.toString(),new InvoiceMapper(),id);
		return list.isEmpty()?null:list.get(0);
	}

	


	

}
