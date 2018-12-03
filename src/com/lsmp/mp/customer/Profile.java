package com.lsmp.mp.customer;

import java.io.Serializable;
import java.util.Set;



/**
 * This class is a customer model class
 * @author samzi
 *
 */

public class Profile implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//Customer instance variables
	private String profileID;
	private String loginID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private Set<Address> addresses;
	private Set<Phone> phones;
	private Set<Bill> billingsInfo;
		
	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public Set<Phone> getPhones() {
		return phones;
	}
	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}
	public Set<Bill> getBillingsInfo() {
		return billingsInfo;
	}
	public void setBillingsInfo(Set<Bill> billingsInfo) {
		this.billingsInfo = billingsInfo;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
