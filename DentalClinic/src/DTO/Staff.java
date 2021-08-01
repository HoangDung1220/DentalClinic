package DTO;

import java.util.Date;

public class Staff extends AbstractPerson<Staff> {
	private String email;
	private Date dateStartWork;
	private String username;
	private String password;
	private int idRole;
	private Role role;
	
	public Staff() {
		super();
	}

	public Staff(String email, Date dateStartWork, String username, String password, int idRole) {
		super();
		this.email = email;
		this.dateStartWork = dateStartWork;
		this.username = username;
		this.password = password;
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


	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
	

}
