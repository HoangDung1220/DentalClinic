package DTO;

import java.sql.Date;
import java.sql.Timestamp;

public class MedicalForm {
	private int id;
	private int idDoctor;
	private Timestamp dateCure;
	private String createdBy;
	private Timestamp modifiedDate;
	private String modifiedBy;
	private String statusOfPatient;//Status of patient after they leave dental clinic
	
	public MedicalForm() {
		super();
	}

	public MedicalForm(int id, int idDoctor, Timestamp dateCure, String createdBy,
			Timestamp modifiedDate, String modifiedBy, String statusAfterCure) {
		super();
		this.id = id;
		this.idDoctor = idDoctor;
		this.dateCure = dateCure;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.statusOfPatient = statusAfterCure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Timestamp getDateCure() {
		return dateCure;
	}

	public void setDateCure(Timestamp dateCure) {
		this.dateCure = dateCure;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public String getStatusOfPatient() {
		return statusOfPatient;
	}

	public void setStatusOfPatient(String statusOfPatient) {
		this.statusOfPatient = statusOfPatient;
	}

	
	
	
	
	
	

}
