package DTO;

import java.sql.Date;

public class MedicalForm {
	private int id;
	private int idDoctor;
	private int idPatient;
	private Date dateCure;
	private String statusBeforeCure;
    private String statusAfterCure;
    private String contentCure;
    
    private Patient patient;
    private Staff staff;
    
	

	public MedicalForm() {
		super();
	}


	public MedicalForm(int id, int idDoctor, int idPatient, Date dateCure, String statusBeforeCure,
			String statusAfterCure, String contentCure) {
		super();
		this.id = id;
		this.idDoctor = idDoctor;
		this.idPatient = idPatient;
		this.dateCure = dateCure;
		this.statusBeforeCure = statusBeforeCure;
		this.statusAfterCure = statusAfterCure;
		this.contentCure = contentCure;
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


	public int getIdPatient() {
		return idPatient;
	}


	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}


	public Date getDateCure() {
		return dateCure;
	}


	public void setDateCure(Date dateCure) {
		this.dateCure = dateCure;
	}


	public String getStatusBeforeCure() {
		return statusBeforeCure;
	}


	public void setStatusBeforeCure(String statusBeforeCure) {
		this.statusBeforeCure = statusBeforeCure;
	}


	public String getStatusAfterCure() {
		return statusAfterCure;
	}


	public void setStatusAfterCure(String statusAfterCure) {
		this.statusAfterCure = statusAfterCure;
	}


	public String getContentCure() {
		return contentCure;
	}


	public void setContentCure(String contentCure) {
		this.contentCure = contentCure;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Staff getStaff() {
		return staff;
	}


	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
	

}