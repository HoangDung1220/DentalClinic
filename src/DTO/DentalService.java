package DTO;

import java.sql.Timestamp;

public class DentalService {
	private int id;
	private String nameService;
	private String unit;
	private float price;
	private String warranty;
	private int quantity;
	
	public DentalService() {
		super();
	}

	public DentalService(int id, String nameService, String unit, float price, String warranty,
			int quantity) {
		super();
		this.id = id;
		this.nameService = nameService;
		this.unit = unit;
		this.price = price;
		this.warranty = warranty;
		this.quantity = quantity;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameService() {
		return nameService;
	}

	public void setNameService(String nameService) {
		this.nameService = nameService;
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

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	

}
