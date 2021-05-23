package com.obs.model;

import java.io.Serializable;

public class CustomerModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private long account_number;
	private String nic;
	private String email;
	private String address;
	private int phonenumber;
	private double account_balance;
	private boolean status;
	private String password;
	
	public CustomerModel() {}
	
	public CustomerModel(String name, long account_number, String nic, String email, String address, int phonenumber,
			double account_balance, boolean status, String password) {
		super();
		this.name = name;
		this.account_number = account_number;
		this.nic = nic;
		this.email = email;
		this.address = address;
		this.phonenumber = phonenumber;
		this.account_balance = account_balance;
		this.status = status;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
