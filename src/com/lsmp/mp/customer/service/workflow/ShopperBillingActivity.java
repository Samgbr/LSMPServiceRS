package com.lsmp.mp.customer.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.CustomerManager;
import com.lsmp.mp.customer.service.representation.ShopperBillingRepresentation;

public class ShopperBillingActivity {

	private static CustomerManager customerManager = new CustomerManager();
	
	public ShopperBillingRepresentation getShopperAddress(String id) {
		
		Bill bill = customerManager.getShopperBillingInfo(id);
		
		ShopperBillingRepresentation shopperBillingRepresentation = new ShopperBillingRepresentation();
		shopperBillingRepresentation.setBillID(bill.getBillID());
		shopperBillingRepresentation.setCreditCardNumber(bill.getCreditCardNumber());
		shopperBillingRepresentation.setCvv(bill.getCvv());
		shopperBillingRepresentation.setExpiryMonth(bill.getExpiryMonth());
		shopperBillingRepresentation.setExpiryYear(bill.getExpiryYear());
		shopperBillingRepresentation.setShopperProfileID(bill.getShopperProfileID());
		return shopperBillingRepresentation;
	}

	public ShopperBillingRepresentation insertShopperBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		
		Bill bill = customerManager.insertShopperBillingInfo(bid, id, creditCardNumber, cvv, expiryMonth, expiryYear);
		
		ShopperBillingRepresentation shopperBillingRepresentation = new ShopperBillingRepresentation();
		shopperBillingRepresentation.setBillID(bill.getBillID());
		shopperBillingRepresentation.setCreditCardNumber(bill.getCreditCardNumber());
		shopperBillingRepresentation.setCvv(bill.getCvv());
		shopperBillingRepresentation.setExpiryMonth(bill.getExpiryMonth());
		shopperBillingRepresentation.setExpiryYear(bill.getExpiryYear());
		shopperBillingRepresentation.setShopperProfileID(bill.getShopperProfileID());
		
		return shopperBillingRepresentation;
	}

	public String updateShopperBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		customerManager.updateShopperBillingInfo(bid, id, creditCardNumber, cvv, expiryMonth, expiryYear);
		return "OK";
	}

	public String deleteShopperBillingInfo(String id) {
		customerManager.deleteShopperBillingInfo(id);
		return "OK";
	}
	
	public Set<ShopperBillingRepresentation> getShopperBillingInfos(String id) {
		Set<Bill> bills = new HashSet<Bill>();
		Set<ShopperBillingRepresentation> shopperBillingRepresentations = new HashSet<ShopperBillingRepresentation>();
		//employees = dao.getAllEmployees();
		bills = customerManager.getShopperBillingInfos(id);
		
		Iterator<Bill> it = bills.iterator();
		while(it.hasNext()) {
          Bill bill = (Bill)it.next();
          ShopperBillingRepresentation shopperBillingRepresentation = new ShopperBillingRepresentation();
          shopperBillingRepresentation.setBillID(bill.getBillID());
  		  shopperBillingRepresentation.setCreditCardNumber(bill.getCreditCardNumber());
  		  shopperBillingRepresentation.setCvv(bill.getCvv());
  		  shopperBillingRepresentation.setExpiryMonth(bill.getExpiryMonth());
  		  shopperBillingRepresentation.setExpiryYear(bill.getExpiryYear());
  		  shopperBillingRepresentation.setShopperProfileID(bill.getShopperProfileID());
          
          //now add this representation in the list
  		shopperBillingRepresentations.add(shopperBillingRepresentation);
        }
		return shopperBillingRepresentations;
	}

}
