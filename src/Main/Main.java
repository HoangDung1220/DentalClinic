package Main;

import BUS.PatientBUS;
import BUS.impl.IPatientBUS;

import DTO.Patient;

public class Main {

	public static void main(String[] args)  {
		

		IPatientBUS patient = new PatientBUS() ;
		Patient p = new Patient();
		p.setAddress("Dai Loc");
		p.setFullname("Hoang Duy");
		p.setCreatedBy("Hong");
		p.setGender((byte) 1);
		p.setiCard("245689");
		p.setPhone("06551175");
		p.setStatus(1);

		
		
		patient.insert(p);
		
		
		//patient.delete(3);
		
		
	}

	

}
