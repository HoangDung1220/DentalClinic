package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.Invoice;
import DTO.Staff;

public class InvoiceMapper implements RowMapper<Invoice> {

	@Override
	public Invoice mapRow(ResultSet rs) {
		Invoice invoice = new Invoice();
		try {
			invoice.setId(rs.getString("id"));
			invoice.setIdMedicalForm(rs.getInt("id_medical_form"));
			invoice.setTotalPriceMedicine(rs.getDouble("total_price_medicine"));
			invoice.setTotalPriceService(rs.getDouble("total_price_service"));
			invoice.setTotalPrice(rs.getDouble("total_price"));
			invoice.setIdStaff(rs.getInt("id_staff"));
			invoice.setPayDate(rs.getTimestamp("pay_date"));
			
			try {
				Staff staff = new StaffMapper().mapRow(rs);
				invoice.setStaff(staff);
			}
			catch (Exception e) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return invoice;
	}

}
