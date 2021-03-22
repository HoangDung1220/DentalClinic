package DTO;

import java.sql.Timestamp;

public class MedicalRecord {
	private int id;
	private int idPatient;
	private String createdBy;
	private Timestamp createdDate;
	
	public MedicalRecord() {
		super();
	}

	public MedicalRecord(int id, int idPatient, String createdBy, Timestamp createdDate) {
		super();
		this.id = id;
		this.idPatient = idPatient;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
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
	
	
	
	

}
