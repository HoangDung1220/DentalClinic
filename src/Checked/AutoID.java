package Checked;

import java.sql.Date;

public class AutoID {
	public static String CreateAutoID(int id_patient) {
		StringBuilder st = new StringBuilder("HD");
		st.append(id_patient);
		Date date = new Date(System.currentTimeMillis());
		st.append(date);
		return st.toString();
		
	}

}
