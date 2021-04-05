package TestMain;

import java.sql.Date;
import java.sql.Timestamp;

import BUS.IMedicineBUS;
import BUS.IPatientBUS;
import BUS.IStaffBUS;
import BUS.implement.MedicineBUS;
import BUS.implement.PatientBUS;
import BUS.implement.StaffBUS;
import DTO.Medicine;
import DTO.Patient;
import DTO.Staff;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		IMedicineBUS medicine = new MedicineBUS();
		
		Medicine m = new Medicine();
		m.setCodeMedicine("pana");
		m.setIdTypeMedicine(3);
		m.setNameMedicine("panaheader1");
		m.setPrice(10.5);
		m.setQuantity(100);
		m.setUnit("viên thuốc");
		m.setId(2);
		/*
		medicine.insert(m);*/
		medicine.update(m);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	Date d1 = new Date(2000, 11, 21);
        d1.setYear(d1.getYear()-1900);
        d1.setMonth(d1.getMonth()-1);

		
		IPatientBUS patient = new PatientBUS() ;
		IStaffBUS staff = new StaffBUS();
		Staff s = new Staff();
		s.setAddress("dai loc-quang nam");
		s.setEmail("nnhoangdungdh@gmail.com");
		s.setIdRole(2);
		s.setBirthday(d1);
		s.setCreatedBy("Dung");
		s.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		s.setDateStartWork(d1);
		s.setFullname("hoang dung");
		s.setGender((byte) 0);
		s.setiCard("1234");
		s.setPassword("200201");
		s.setPhone("0365551975");
		s.setStatus(0);
		s.setUsername("hoangdung");
		s.setId(3);
		s.setModifiedBy("an");
		s.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		
	//	staff.update(s);
		staff.delete(s.getId());
	/*	Patient p = new Patient();
		p.setAddress("Dai Loc");
		p.setFullname("An");
		p.setCreatedBy("Hong");
		p.setGender((byte) 1);
		p.setiCard("10211");
		p.setPhone("06551175");
		p.setStatus(1);
		p.setBirthday(d1);
		p.setCreatedDate(new Timestamp(System.currentTimeMillis()));*/

		
	//	patient.insert(p);
		
	/*	Patient p1 = new Patient();
		p1.setId(6);
		p1.setAddress("Dai Loc- Quang Nam");
		p1.setFullname("An");
		p1.setModifiedBy("My My");
		p1.setGender((byte) 0);
		p1.setiCard("102121");
		p1.setPhone("06551175");
		p1.setStatus(1);
		p1.setBirthday(d1);
		p1.setModifiedDate(new Timestamp(System.currentTimeMillis()));

*/
		
		//patient.insert(p);
		//patient.update(p1);
		
		//delete
		
		//int id =1;
		//patient.delete(id);
		
		

	}

}
