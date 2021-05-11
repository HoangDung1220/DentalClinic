package TestMain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import BUS.IPatientBUS;
import BUS.implement.PatientBUS;
import DTO.Patient;

@SuppressWarnings("deprecation")
public class Test {

	
	public static void main(String[] args) {
		
		
        
		Date d1 = new Date(2000, 11, 21);
        d1.setYear(d1.getYear()-1900);
        d1.setMonth(d1.getMonth()-1);
        
        Patient p = new Patient();
        p.setId(2);
        p.setFullname("An");
        p.setGender((byte) 1);
        p.setBirthday(d1);
        p.setPhone("06551175");
		p.setAddress("Dai Loc");
		p.setiCard("10211");
		p.setCreatedBy("Hong");
		p.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		p.setModifiedBy("Hong");
		p.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		p.setStatus(1);
		
		
		
		//patient.insert(p);
   
	
	}

}