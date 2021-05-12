package DTO;

public class DetailService {
	private int id;
	private int idDentalService;
	private int idMedicalForm;
	private int quantity;
	private double price;
	private DentalService dentalService;
	public DetailService() {
		super();
	}
	public DetailService(int id, int idDentalService, int idMedicalForm, int quantity, double price) {
		super();
		this.id = id;
		this.idDentalService = idDentalService;
		this.idMedicalForm = idMedicalForm;
		this.quantity = quantity;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdDentalService() {
		return idDentalService;
	}
	public void setIdDentalService(int idDentalService) {
		this.idDentalService = idDentalService;
	}
	public int getIdMedicalForm() {
		return idMedicalForm;
	}
	public void setIdMedicalForm(int idMedicalForm) {
		this.idMedicalForm = idMedicalForm;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public DentalService getDentalService() {
		return dentalService;
	}
	public void setDentalService(DentalService dentalService) {
		this.dentalService = dentalService;
	}
	
	
	

}
