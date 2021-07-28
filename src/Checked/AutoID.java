package Checked;

import java.sql.Date;

import BUS.implement.InvoiceBUS;


public class AutoID {

	private static InvoiceBUS invoice = new InvoiceBUS();
	
	@SuppressWarnings("deprecation")
	public static String CreateAutoID(int id_patient) {
		StringBuilder st = new StringBuilder();
		st.append(id_patient);
		Date date = new Date(System.currentTimeMillis());
		int day = date.getDay();
		st.append(String.valueOf(day));
		int month = date.getMonth();
		st.append(String.valueOf(month));
		int year = date.getYear();
		st.append(String.valueOf(year));
		int count = invoice.count(id_patient);
		st.append(String.valueOf(count));
		return st.toString();
		
	}

}
