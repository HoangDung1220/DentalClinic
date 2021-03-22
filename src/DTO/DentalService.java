package DTO;

import java.sql.Timestamp;

public class DentalService {
	private int id;
	private String nameService;
	private String codeService;
	private String unit;
	private float price;
	private String warranty;
	private int quantity;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp modifiedDate;
	
	public DentalService() {
		super();
	}

	public DentalService(int id, String nameService, String codeService, String unit, float price, String warranty,
			int quantity, String createdBy, Timestamp createdDate, String modifiedBy, Timestamp modifiedDate) {
		super();
		this.id = id;
		this.nameService = nameService;
		this.codeService = codeService;
		this.unit = unit;
		this.price = price;
		this.warranty = warranty;
		this.quantity = quantity;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
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

	public String getCodeService() {
		return codeService;
	}

	public void setCodeService(String codeService) {
		this.codeService = codeService;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
	

}
