package com.obs.model;

import java.io.Serializable;

public class EmployeeModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private  String eid;
	private  String name;
	private String email;
	private String nic;
	private String address;
	private String phonenumber;
	private  String password;
	
	public EmployeeModel() {}
	
	public EmployeeModel(String eid, String name, String email, String address, String phonenumber,
			String password, String nic) {
		super();
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.nic = nic;
		this.address = address;
		this.phonenumber = phonenumber;
		this.password = password;
	}

	public  String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public  String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public  String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
