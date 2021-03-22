package DTO;

import java.sql.Date;
import java.sql.Timestamp;

public class MedicalForm {
	private int id;
	private int idMedicalRecord;
	private int idDoctor;
	private Timestamp dateCure;
	private String createdBy;
	private Timestamp modifiedDate;
	private String modifiedBy;
	private Date re_ExaminationDate;
	private String statusAfterCure;//Status of patient after they leave dental clinic
	
	public MedicalForm() {
		super();
	}

	public MedicalForm(int id, int idMedicalRecord, int idDoctor, Timestamp dateCure, String createdBy,
			Timestamp modifiedDate, String modifiedBy, Date re_ExaminationDate, String statusAfterCure) {
		super();
		this.id = id;
		this.idMedicalRecord = idMedicalRecord;
		this.idDoctor = idDoctor;
		this.dateCure = dateCure;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.re_ExaminationDate = re_ExaminationDate;
		this.statusAfterCure = statusAfterCure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMedicalRecord() {
		return idMedicalRecord;
	}

	public void setIdMedicalRecord(int idMedicalRecord) {
		this.idMedicalRecord = idMedicalRecord;
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

	public Date getRe_ExaminationDate() {
		return re_ExaminationDate;
	}

	public void setRe_ExaminationDate(Date re_ExaminationDate) {
		this.re_ExaminationDate = re_ExaminationDate;
	}

	public String getStatusAfterCure() {
		return statusAfterCure;
	}

	public void setStatusAfterCure(String statusAfterCure) {
		this.statusAfterCure = statusAfterCure;
	}
	
	
	
	
	
	

}
