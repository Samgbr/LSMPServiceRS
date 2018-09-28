package com.lsmp.mp.customer;

import java.util.Set;

/**
 * This class is a customer model class
 * @author samzi
 *
 */
public class Customer {

	//Customer instance variables
	private String customerID;
	private String loginID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private String shopperType;
	private Set<Address> addresses;
	private Set<Phone> phones;
	private Set<Bill> billingsInfo;
		
	public String getShopperType() {
		return shopperType;
	}
	public void setShopperType(String shopperType) {
		this.shopperType = shopperType;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
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
