package com.lsmp.mp.partner.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.partner.PartnerManager;
import com.lsmp.mp.partner.PartnerProduct;
import com.lsmp.mp.partner.service.representation.PartnerSmartphoneRepresentation;

public class PartnerSmartphoneActivity {

	public static PartnerManager partnerManager=new PartnerManager();
	
	public PartnerSmartphoneRepresentation getPartnerSmarphoneProfileBYProductID(String id) {
		
		PartnerProduct partnerProduct=partnerManager.getPartnerSmarphoneProfileBYProductID(id);
		
		PartnerSmartphoneRepresentation partnerSmartphoneRepresentation=new PartnerSmartphoneRepresentation();
		
		partnerSmartphoneRepresentation.setPartnerProduct(partnerProduct.getPartnerProduct());
		partnerSmartphoneRepresentation.setProductPartnerID(partnerProduct.getProductPartnerID());
		
		return partnerSmartphoneRepresentation;
	}
	
	public Set<PartnerSmartphoneRepresentation> getAllPartnerSmartphones() {
		
		Set<PartnerProduct> partnerProducts = new HashSet<PartnerProduct>();
		Set<PartnerSmartphoneRepresentation> partnerSmartphoneRepresentations = new HashSet<PartnerSmartphoneRepresentation>();
		
		partnerProducts = partnerManager.getAllPartnerSmartphones();		
		Iterator<PartnerProduct> it = partnerProducts.iterator();
		while(it.hasNext()) {
			PartnerProduct partnerProduct = (PartnerProduct)it.next();
          
			PartnerSmartphoneRepresentation partnerSmartphoneRepresentation=new PartnerSmartphoneRepresentation();
			
			partnerSmartphoneRepresentation.setPartnerProduct(partnerProduct.getPartnerProduct());
			partnerSmartphoneRepresentation.setProductPartnerID(partnerProduct.getProductPartnerID());
          
          //now add this representation in the list
			partnerSmartphoneRepresentations.add(partnerSmartphoneRepresentation);
        }
		return partnerSmartphoneRepresentations;
	}
	
	public String deletePartnerSmartphone(String id) {
		partnerManager.deletePartnerSmartphone(id);
		return "OK";
	}

	public PartnerSmartphoneRepresentation addPartnerSmartphone(String ppid, String id, String profileID) {
		
		PartnerProduct partnerProduct = partnerManager.addPartnerSmartphone(ppid, id, profileID);
		
		PartnerSmartphoneRepresentation partnerSmartphoneRepresentation=new PartnerSmartphoneRepresentation();
		
		partnerSmartphoneRepresentation.setPartnerProduct(partnerProduct.getPartnerProduct());
		partnerSmartphoneRepresentation.setProductPartnerID(partnerProduct.getProductPartnerID());
		
		return partnerSmartphoneRepresentation;
	}

	public String updatePartnerSmartphone(String id, String profileID) {
		
		partnerManager.updatePartnerSmartphone(id, profileID);
		
		return "OK";
	}
}
