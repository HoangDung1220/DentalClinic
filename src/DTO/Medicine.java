package DTO;

public class Medicine {
	private int id;
	private String nameMedicine;
	private String codeMedicine;
	private int idTypeMedicine;
	private String unit;
	private double price;
	private int quantity;
	private TypeMedicine typeMedicine;
	public Medicine() {
		super();
	}

	public Medicine(int id, String nameMedicine, String codeMedicine, int idType, String unit, double price,
			int quantity) {
		super();
		this.id = id;
		this.nameMedicine = nameMedicine;
		this.codeMedicine = codeMedicine;
		this.idTypeMedicine = idType;
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

	public int getIdTypeMedicine() {
		return idTypeMedicine;
	}

	public void setIdTypeMedicine(int idType) {
		this.idTypeMedicine = idType;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public TypeMedicine getTypeMedicine() {
		return typeMedicine;
	}

	public void setTypeMedicine(TypeMedicine typeMedicine) {
		this.typeMedicine = typeMedicine;
	}
	
	
	

}
