package DTO;

import java.sql.Timestamp;

public class Invoice {
	private String id;
	private int idMedicalForm;
	private int idStaff;
	private double totalPriceMedicine;
	private double totalPriceService;
	private Timestamp payDate;
	private double totalPrice;
	private Staff staff;
	
	public Invoice() {
		super();
	}

	public Invoice(String id, int idMedicalForm, int idStaff, float totalPriceMedicine, double totalPriceService,
			Timestamp payDate) {
		super();
		this.id = id;
		this.idMedicalForm = idMedicalForm;
		this.idStaff = idStaff;
		this.totalPriceMedicine = totalPriceMedicine;
		this.totalPriceService = totalPriceService;
		this.payDate = payDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public double getTotalPriceMedicine() {
		return totalPriceMedicine;
	}

	public void setTotalPriceMedicine(double totalPriceMedicine) {
		this.totalPriceMedicine = totalPriceMedicine;
	}

	public double getTotalPriceService() {
		return totalPriceService;
	}

	public void setTotalPriceService(double totalPriceService) {
		this.totalPriceService = totalPriceService;
	}

	public Timestamp getPayDate() {
		return payDate;
	}

	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}

	

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
	

}
