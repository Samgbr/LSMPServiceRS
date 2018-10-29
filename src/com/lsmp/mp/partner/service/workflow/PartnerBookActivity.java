package com.lsmp.mp.partner.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	
	public Set<PartnerBookRepresentation> getAllPartnerBooks() {
		
		Set<PartnerProduct> partnerProducts = new HashSet<PartnerProduct>();
		Set<PartnerBookRepresentation> partnerBookRepresentations = new HashSet<PartnerBookRepresentation>();
		
		partnerProducts = partnerManager.getAllPartnerBooks();
		
		Iterator<PartnerProduct> it = partnerProducts.iterator();
		while(it.hasNext()) {
			PartnerProduct partnerProduct = (PartnerProduct)it.next();
          
			PartnerBookRepresentation partnerBookRepresentation=new PartnerBookRepresentation();
			
			partnerBookRepresentation.setPartnerProduct(partnerProduct.getPartnerProduct());
			partnerBookRepresentation.setProductPartnerID(partnerProduct.getProductPartnerID());
          
          //now add this representation in the list
  		partnerBookRepresentations.add(partnerBookRepresentation);
        }
		return partnerBookRepresentations;
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
