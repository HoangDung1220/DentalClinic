package DTO;

import java.sql.Date;

public class Staff extends AbstractPerson<Staff> {
	private String email;
	private Date dateStartWork;
	private String username;
	private String password;
	private int status;
	private int idRole;
	
	public Staff() {
		super();
	}

	public Staff(String email, Date dateStartWork, String username, String password, int status, int idRole) {
		super();
		this.email = email;
		this.dateStartWork = dateStartWork;
		this.username = username;
		this.password = password;
		this.status = status;
		this.idRole = idRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateStartWork() {
		return dateStartWork;
	}

	public void setDateStartWork(Date dateStartWork) {
		this.dateStartWork = dateStartWork;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	
	

}
