package com.lsmp.mp.product.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.product.ProductManager;
import com.lsmp.mp.product.Smartphone;
import com.lsmp.mp.product.service.representation.SmartphoneRepresentation;

public class SmartphoneActivity {

public static ProductManager productManager=new ProductManager();
	
	public SmartphoneRepresentation getSmartphone(String id) {
		
		Smartphone smartphone=productManager.getSmartphone(id);
		
		SmartphoneRepresentation smartphoneRepresentation=new SmartphoneRepresentation();
		
		smartphoneRepresentation.setProductID(smartphone.getProductID());
		smartphoneRepresentation.setPurchasePrice(smartphone.getPurchasePrice());
		smartphoneRepresentation.setSellingPrice(smartphone.getSellingPrice());
		smartphoneRepresentation.setDisplayInch(smartphone.getDisplayInch());
		smartphoneRepresentation.setBrand(smartphone.getBrand());
		smartphoneRepresentation.setRamSize(smartphone.getRamSize());
		smartphoneRepresentation.setOs(smartphone.getOs());
		smartphoneRepresentation.setStorageSize(smartphone.getStorageSize());
		
		return smartphoneRepresentation;
	}

	public Set<SmartphoneRepresentation> getSmartphones() {
		
		Set<Smartphone> smartphones = new HashSet<Smartphone>();
		Set<SmartphoneRepresentation> smartphoneRepresentations = new HashSet<SmartphoneRepresentation>();
		
		smartphones = productManager.getAllSmartphones();
		
		Iterator<Smartphone> it = smartphones.iterator();
		while(it.hasNext()) {
          Smartphone smartphone = (Smartphone)it.next();
          SmartphoneRepresentation smartphoneRepresentation=new SmartphoneRepresentation();
  		
  		smartphoneRepresentation.setProductID(smartphone.getProductID());
  		smartphoneRepresentation.setPurchasePrice(smartphone.getPurchasePrice());
  		smartphoneRepresentation.setSellingPrice(smartphone.getSellingPrice());
  		smartphoneRepresentation.setDisplayInch(smartphone.getDisplayInch());
  		smartphoneRepresentation.setBrand(smartphone.getBrand());
  		smartphoneRepresentation.setRamSize(smartphone.getRamSize());
  		smartphoneRepresentation.setOs(smartphone.getOs());
  		smartphoneRepresentation.setStorageSize(smartphone.getStorageSize());
          
          //now add this representation in the list
  		smartphoneRepresentations.add(smartphoneRepresentation);
        }
		return smartphoneRepresentations;
	}

	public String deleteSmartphone(String id) {
		productManager.deleteSmartphone(id);
		return "OK";
	}

	public SmartphoneRepresentation createSmartphone(String id, double purchasePrice, double sellingPrice, String displayInch, String brand,
			String ramSize, String os, String storageSize) {
		
		Smartphone smartphone = productManager.addSmartphone(id, null, null, purchasePrice, sellingPrice, 0.0, displayInch, brand, ramSize, os, storageSize);
		
		SmartphoneRepresentation smartphoneRepresentation=new SmartphoneRepresentation();
        
		smartphoneRepresentation.setProductID(smartphone.getProductID());
  		smartphoneRepresentation.setPurchasePrice(smartphone.getPurchasePrice());
  		smartphoneRepresentation.setSellingPrice(smartphone.getSellingPrice());
  		smartphoneRepresentation.setDisplayInch(smartphone.getDisplayInch());
  		smartphoneRepresentation.setBrand(smartphone.getBrand());
  		smartphoneRepresentation.setRamSize(smartphone.getRamSize());
  		smartphoneRepresentation.setOs(smartphone.getOs());
  		smartphoneRepresentation.setStorageSize(smartphone.getStorageSize());
		
		return smartphoneRepresentation;
	}

	public String updateSmartphone(String id, double purchasePrice, double sellingPrice, String displayInch, String brand,
			String ramSize, String os, String storageSize) {
		
		productManager.updateSmartphone(id, null, null, purchasePrice, sellingPrice, 0.0, displayInch, brand, ramSize, os, storageSize);
		
		return "OK";
	}

}
