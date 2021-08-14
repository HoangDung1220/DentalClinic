package BUS.implement;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import BUS.IPatientBUS;
import DAL.IStaffDAL;
import DAL.implement.PatientDAL;
import DAL.implement.StaffDAL;
import DTO.DetailService;
import DTO.Invoice;
import DTO.MedicalForm;
import DTO.Patient;
import DTO.Prescription;
import PAGING.Pageble;

public class PatientBUS implements IPatientBUS{
	
	PatientDAL patient;
	MedicalFormBUS medicalForm = new MedicalFormBUS();
	DetailServiceBUS detail = new DetailServiceBUS();
	PrescriptionBUS prescription = new PrescriptionBUS();
	InvoiceBUS invoice = new InvoiceBUS();
	
	public PatientBUS (){
		patient = new PatientDAL();
	}

	@Override
	public List<Patient> findAll() {

		return patient.findAll();
	}

	@Override
	public int insert(Patient p) {
				return patient.insert(p);
	}

	@Override
	public void update(Patient p) {

		
		patient.update(p);
		
	}

//	@Override
//	public void delete(List<Integer> list) {
//
//		for (int i: list) {
//			patient.delete(i);
//			
//		}
//	}
	
	
	@Override
	public void delete(List<Integer> list) {

		for (Integer i: list) 
		{
			List<MedicalForm> listMedical = medicalForm.findAllByPatient(i);
			List<Integer> listIdMedical = new ArrayList<Integer>();
			for (MedicalForm j : listMedical) 
			{
				listIdMedical.add(j.getId());
			}
			for (Integer k : listIdMedical) 
			{
				List<DetailService> listDetail = detail.findAll(k);
				List<Integer> listIdDetail = new ArrayList<Integer>();
				for (DetailService j:listDetail) 
				{
					listIdDetail.add(j.getId());
				}
				detail.delete(listIdDetail);
			}
			
			for (Integer k : listIdMedical) 
			{
				List<Prescription> listPrescription = prescription.findAll(k);
				List<Integer> listIdPrescription = new ArrayList<Integer>();
				for (Prescription j:listPrescription) 
				{
					listIdPrescription.add(j.getId());
				}
				prescription.delete(listIdPrescription);
			}
			for (Integer k : listIdMedical) 
			{
				Invoice in = invoice.findOneByIdMedical(k);
				if (in!=null) 
				{
					invoice.Delete(in.getId());
				}
			}
			
			
			medicalForm.delete(listIdMedical);
			patient.delete(i);
		
		}
	}

	@Override
	public Patient findOne(int id) {
		return patient.findOne(id);
	}
	@Override
	public Patient findOneByIcard(String icard) {
		return patient.findOneByIcard(icard);
		
	}
	@Override
	public List<Patient> searchByNameAndIcard(String name, String icard) {
		return patient.searchByNameAndIcard(name,icard);
	}

	@Override
	public List<Patient> searchByName(String fullname) {
		return patient.searchByName(fullname);
	}

	@Override
	public List<Patient> searchByIcard(String icard) {
		// TODO Auto-generated method stub
		return patient.searchByIcard(icard);
	}

	@Override
	public List<Patient> findAllByDate() {
		return patient.findAllByDate();
	}

	@Override
	public List<Patient> findAllPaging(Pageble pageble) {
		return patient.findAllPage(pageble);
	}

	@Override
	public List<Patient> findAllPage(Pageble pageble, Date date1, Date date2) {
		return patient.findAllPage(pageble,date1,date2);

	}

	@Override
	public List<Patient> findAllPage(Date date1, Date date2) {
		return patient.findAllPage(date1,date2);
	}

}
