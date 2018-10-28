package com.lsmp.mp.partner.service.workflow;

import com.lsmp.mp.partner.PartnerManager;
import com.lsmp.mp.partner.PartnerProduct;
import com.lsmp.mp.partner.service.representation.PartnerBookRepresentation;

public class PartnerBookActivity {

public static PartnerManager partnerManager=new PartnerManager();
	
	public PartnerBookRepresentation getPartnerBookProfileBYProductID(String id) {
		
		PartnerProduct partnerProduct=partnerManager.getPartnerBookProfileBYProductID(id);
		
		PartnerBookRepresentation partnerBookRepresentation=new PartnerBookRepresentation();
		
		partnerBookRepresentation.setPartnerProduct(partnerProduct.getPartnerProduct());
		partnerBookRepresentation.setProductPartnerID(partnerProduct.getProductPartnerID());
		
		return partnerBookRepresentation;
	}
	
	public String deletePartnerBook(String id) {
		partnerManager.deletePartnerBook(id);
		return "OK";
	}

	public PartnerBookRepresentation addPartnerBook(String ppid, String id, String profileID) {
		
		PartnerProduct partnerProduct = partnerManager.addPartnerBook(ppid, id, profileID);
		
		PartnerBookRepresentation partnerBookRepresentation=new PartnerBookRepresentation();
        
		partnerBookRepresentation.setPartnerProduct(partnerProduct.getPartnerProduct());
		partnerBookRepresentation.setProductPartnerID(partnerProduct.getProductPartnerID());
		
		return partnerBookRepresentation;
	}

	public String updatePartnerBook(String id, String profileID) {
		
		partnerManager.updatePartnerBook(id, profileID);
		
		return "OK";
	}
}
