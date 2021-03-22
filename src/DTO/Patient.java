package DTO;

public class Patient extends AbstractPerson<Patient>{
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

}
