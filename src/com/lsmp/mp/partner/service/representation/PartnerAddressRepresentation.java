package com.lsmp.mp.partner.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "partnerAddressRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PartnerAddressRepresentation {

	private String addressID;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String partnerProfileID;
	
	public String getAddressID() {
		return addressID;
	}
	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPartnerProfileID() {
		return partnerProfileID;
	}
	public void setPartnerProfileID(String partnerProfileID) {
		this.partnerProfileID = partnerProfileID;
	}
	
	
}
