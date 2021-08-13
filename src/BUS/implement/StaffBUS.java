package BUS.implement;

import java.util.ArrayList;
import java.util.List;

import BUS.IStaffBUS;
import DAL.IStaffDAL;
import DAL.implement.StaffDAL;
import DTO.DetailService;
import DTO.Invoice;
import DTO.MedicalForm;
import DTO.Prescription;
import DTO.Staff;
import PAGING.Pageble;

public class StaffBUS implements IStaffBUS{
	
	MedicalFormBUS medicalForm = new MedicalFormBUS();
	IStaffDAL staff = new StaffDAL();
	DetailServiceBUS detail = new DetailServiceBUS();
	PrescriptionBUS prescription = new PrescriptionBUS();
	InvoiceBUS invoice = new InvoiceBUS();
	@Override
	public List<Staff> findAll() {
		return staff.findAll();
	}

	@Override
	public int insert(Staff p) {
		
		return staff.insert(p);		
	}

	@Override
	public void update(Staff p) {
		staff.update(p);
	}

	@Override
	public void delete(List<Integer> list) {
		for (Integer i: list) {
			List<MedicalForm> listMedical = medicalForm.findAll(i);
			List<Integer> listIdMedical = new ArrayList<Integer>();
			for (MedicalForm j : listMedical) {
				listIdMedical.add(j.getId());
			}
			for (Integer k : listIdMedical) {
				List<DetailService> listDetail = detail.findAll(k);
				List<Integer> listIdDetail = new ArrayList<Integer>();
				for (DetailService j:listDetail) {
					listIdDetail.add(j.getId());
				}
				detail.delete(listIdDetail);
			}
			
			for (Integer k : listIdMedical) {
				List<Prescription> listPrescription = prescription.findAll(k);
				List<Integer> listIdPrescription = new ArrayList<Integer>();
				for (Prescription j:listPrescription) {
					listIdPrescription.add(j.getId());
				}
				prescription.delete(listIdPrescription);
			}
			for (Integer k : listIdMedical) {
				Invoice in = invoice.findOneByIdMedical(k);
				if (in!=null) {
					invoice.Delete(in.getId());
				}
			}
			
			
			medicalForm.delete(listIdMedical);
			staff.delete(i);
		
		}
	}

	@Override
	public Staff findOne(int id) {
		return staff.findOne(id);
	}

	@Override
	public Staff searchByUserNameAndPassword(String username, String password) {
		
		return staff.searchByUserNameAndPassword(username, password);
	}

	@Override
	public List<Staff> searchByIDOrName(int id, String name) {
		return staff.searchByIDOrName(id, name);
	}

	@Override
	public List<Staff> findStaffWithPage(Pageble pageble) {
		return staff.findStaffWithPage(pageble);
	}

	@Override
	public Staff searchByNameAndICard(String fullname, String card) {
		
		return staff.searchByNameAndICard(fullname, card);
	}

}
