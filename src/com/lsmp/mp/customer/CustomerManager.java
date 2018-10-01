package com.lsmp.mp.customer;

import java.util.Set;

import com.lsmp.dal.customer.ShopperDAO;

/**
 * Manager class for Customer Profile
 * @author samzi
 *
 */

public class CustomerManager {

	//Shopper DAO
	private static ShopperDAO sDAO = new ShopperDAO();
	
	public Shopper getShopperProfile(String id) {
		return sDAO.getShopperProfile(id);
	}
	
	public Shopper addShopperProfile(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		
		Shopper shopper = sDAO.addShopperProfile(id,loginID, firstName, middleName, lastName, email, password, shopperType,addresses, phones,bills);
		
		return shopper;
	}

	public void updateShopperProfile(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType, Set<Address> addresses,Set<Phone> phones, Set<Bill> bills) {
		sDAO.updateShopperProfile(id, loginID, firstName, middleName, lastName, email, password, shopperType, addresses, phones,bills);
	}

	public void deleteShopperProfile(String id) {
		sDAO.deleteShopperProfile(id);
	}
	
	public Shopper createShopper(String profileID, String loginID, String firstName, String middleName, String lastName,
			String email, String password, String shoppertype) {
		Shopper shopper = new Shopper();
		shopper.setProfileID(profileID);
		shopper.setLoginID(loginID);
		shopper.setFirstName(firstName);
		shopper.setMiddleName(middleName);
		shopper.setLastName(lastName);
		shopper.setEmail(email);
		shopper.setPassword(password);
		shopper.setShopperType(shoppertype);
		return shopper;
	}
	
	public Address createAddress(String addressID, String street, String city, String state, String zipcode) {
		Address address = new Address();
		address.setAddressID(addressID);
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZipcode(zipcode);
		return address;
	}
	
	public Phone createPhone(String phoneID, String type, String phoneNumber) {
		Phone phone = new Phone();
		phone.setPhoneID(phoneID);
		phone.setType(type);
		phone.setPhoneNumber(phoneNumber);
		return phone;
	}
	
	public Bill createBill(String billID, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		Bill bill = new Bill();
		bill.setBillID(billID);
		bill.setCreditCardNumber(creditCardNumber);
		bill.setCvv(cvv);
		bill.setExpiryMonth(expiryMonth);
		bill.setExpiryYear(expiryYear);
		return bill;
	}
	
	
}
