package com.lsmp.mp.partner;

import java.util.Map;

public class PartnerProduct {

	//ProductID and ProfileID
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
