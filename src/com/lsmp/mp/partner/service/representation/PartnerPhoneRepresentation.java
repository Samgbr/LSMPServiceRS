package com.lsmp.mp.partner.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "partnerPhoneRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PartnerPhoneRepresentation {

	private String phoneID;
	private String type;
	private String phoneNumber;
	private String partnerProfileID;
	
	public String getPhoneID() {
		return phoneID;
	}
	public void setPhoneID(String phoneID) {
		this.phoneID = phoneID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPartnerProfileID() {
		return partnerProfileID;
	}
	public void setPartnerProfileID(String partnerProfileID) {
		this.partnerProfileID = partnerProfileID;
	}
	
}
