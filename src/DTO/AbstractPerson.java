package DTO;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractPerson<T> {
	private int id;
	private String fullname;
	private byte gender;
	private String address;
	private Date birthday;
	private String phone;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp modifiedDate;
	private String iCard;
	private List<T> list = new ArrayList<T>();
	
	public AbstractPerson() {
		
	}


	public AbstractPerson(int id, String fullname, byte gender, String address, Date birthday, String phone,
			String createdBy, Timestamp createdDate, String modifiedBy, Timestamp modifiedDate, String iCard) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.phone = phone;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.iCard = iCard;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public byte getGender() {
		return gender;
	}


	public void setGender(byte gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
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


	public String getiCard() {
		return iCard;
	}


	public void setiCard(String iCard) {
		this.iCard = iCard;
	}


	public List<T> getList() {
		return list;
	}


	public void setList(List<T> list) {
		this.list = list;
	}


	
	
	
	

}
