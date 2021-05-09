package DTO;

import java.sql.Timestamp;

public class Invoice {
	private int id;
	private int idMedicalForm;
	private int idStaff;
	private float totalPriceMedicine;
	private float totalPriceService;
	private Timestamp payDate;
	private byte status;
	
	public Invoice() {
		super();
	}

	public Invoice(int id, int idMedicalForm, int idStaff, float totalPriceMedicine, float totalPriceService,
			Timestamp payDate, byte status) {
		super();
		this.id = id;
		this.idMedicalForm = idMedicalForm;
		this.idStaff = idStaff;
		this.totalPriceMedicine = totalPriceMedicine;
		this.totalPriceService = totalPriceService;
		this.payDate = payDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMedicalForm() {
		return idMedicalForm;
	}

	public void setIdMedicalForm(int idMedicalForm) {
		this.idMedicalForm = idMedicalForm;
	}

	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public float getTotalPriceMedicine() {
		return totalPriceMedicine;
	}

	public void setTotalPriceMedicine(float totalPriceMedicine) {
		this.totalPriceMedicine = totalPriceMedicine;
	}

	public float getTotalPriceService() {
		return totalPriceService;
	}

	public void setTotalPriceService(float totalPriceService) {
		this.totalPriceService = totalPriceService;
	}

	public Timestamp getPayDate() {
		return payDate;
	}

	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}
	
	
	

}
