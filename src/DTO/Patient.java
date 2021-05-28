package DTO;

import java.sql.Timestamp;
import java.util.Date;

public class Patient extends Person<Patient>
{
	private int status;
	
	public Patient() 
	{
		super();
	}

	public Patient(int id, String fullname, boolean gender, String address, Date birthday, String phone,
			String createdBy, Timestamp createdDate, String modifiedBy, Timestamp modifiedDate, String iCard, int status) 
	{
		super(id, fullname, gender, address, birthday, phone, createdBy, createdDate, modifiedBy, modifiedDate, iCard);
		this.status = status;
	}

	public Patient(int status) {
		super();
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	
	
	
}
