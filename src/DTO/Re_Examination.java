package DTO;

public class Re_Examination {
	private int id;
	private int idMedicalForm;
	private byte status;// 0 : chua giai quyet 1 giai quyet
	
	public Re_Examination() {
		super();
	}

	public Re_Examination(int id, int idMedicalForm, byte status) {
		super();
		this.id = id;
		this.idMedicalForm = idMedicalForm;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMedicalForm() {
		return idMedicalForm;
	}

	public void setIdMedicalForm(int idMedicalForm) {
		this.idMedicalForm = idMedicalForm;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}
	
	
	

}
