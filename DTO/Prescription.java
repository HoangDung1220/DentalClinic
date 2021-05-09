package DTO;

public class Prescription {
	private int id;
	private int idMedicine;
	private int idMedicalForm;
	private int quantity;
	private String usage;
	private float price;
	private String note;// ghi chu kieu uong truoc khu an,...
	
	public Prescription() {
		super();
	}

	public Prescription(int id, int idMedicine, int idMedicalForm, int quantity, String usage, float price,
			String note) {
		super();
		this.id = id;
		this.idMedicine = idMedicine;
		this.idMedicalForm = idMedicalForm;
		this.quantity = quantity;
		this.usage = usage;
		this.price = price;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMedicine() {
		return idMedicine;
	}

	public void setIdMedicine(int idMedicine) {
		this.idMedicine = idMedicine;
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

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

}
