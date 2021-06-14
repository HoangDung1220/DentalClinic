package Checked;

import java.sql.Date;

public class AutoID {
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
		
		
		return st.toString();
		
	}

}
