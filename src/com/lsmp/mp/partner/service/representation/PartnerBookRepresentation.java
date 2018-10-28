package com.lsmp.mp.partner.service.representation;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "partnerBookRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PartnerBookRepresentation {

	private String productPartnerID;
	private Map<String,String> partnerProduct;
	
	public String getProductPartnerID() {
		return productPartnerID;
	}
	public void setProductPartnerID(String productPartnerID) {
		this.productPartnerID = productPartnerID;
	}
	public Map<String, String> getPartnerProduct() {
		return partnerProduct;
	}
	public void setPartnerProduct(Map<String, String> partnerProduct) {
		this.partnerProduct = partnerProduct;
	}
	
	
}
