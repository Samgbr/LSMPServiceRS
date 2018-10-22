package com.lsmp.mp.customer.service.workflow;

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

	public String updateShopperAddress(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		customerManager.updateShopperBillingInfo(bid, id, creditCardNumber, cvv, expiryMonth, expiryYear);
		return "OK";
	}

	public String deleteShopperBillingInfo(String id) {
		customerManager.deleteShopperBillingInfo(id);
		return "OK";
	}

}
