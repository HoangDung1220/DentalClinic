package DTO;

public class Medicine {
	private int id;
	private String nameMedicine;
	private String codeMedicine;
	private int idType;
	private String unit;
	private float price;
	private int quantity;

	public Medicine() {
		super();
	}

	public Medicine(int id, String nameMedicine, String codeMedicine, int idType, String unit, float price,
			int quantity) {
		super();
		this.id = id;
		this.nameMedicine = nameMedicine;
		this.codeMedicine = codeMedicine;
		this.idType = idType;
		this.unit = unit;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameMedicine() {
		return nameMedicine;
	}

	public void setNameMedicine(String nameMedicine) {
		this.nameMedicine = nameMedicine;
	}

	public String getCodeMedicine() {
		return codeMedicine;
	}

	public void setCodeMedicine(String codeMedicine) {
		this.codeMedicine = codeMedicine;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
