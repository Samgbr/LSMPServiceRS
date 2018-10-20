package com.lsmp.mp.customer;

import java.util.Set;

import com.lsmp.dal.customer.AddressDAO;
import com.lsmp.dal.customer.ShopperDAO;

/**
 * Manager class for Customer Profile
 * @author samzi
 *
 */

public class CustomerManager {

	//Shopper DAO
	private static ShopperDAO sDAO = new ShopperDAO();
	private static AddressDAO aDAO = new AddressDAO();
	/**
	 * This method get shopper profile with its address, bill and phone
	 * @param id
	 * @return
	 */
	public Shopper getShopperProfile(String id) {
		return sDAO.getShopperProfile(id);
	}
	
	/**
	 * This method get shopper data only
	 * @param id
	 * @return
	 */
	public Shopper getShopper(String id) {
		return sDAO.getShopper(id);
	}
	
	/**
	 * This method add shopper profile with its address, bill and phone data
	 * @param id
	 * @param loginID
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param shopperType
	 * @param addresses
	 * @param phones
	 * @param bills
	 * @return
	 */
	public Shopper addShopperProfile(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		
		Shopper shopper = sDAO.addShopperProfile(id,loginID, firstName, middleName, lastName, email, password, shopperType,addresses, phones,bills);
		
		return shopper;
	}
	
	/**
	 * This method add shopper data only not respective address, bill and phone
	 * @param id
	 * @param loginID
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param shopperType
	 * @return
	 */
	public Shopper addShopper(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType) {
		
		Shopper shopper = sDAO.addShopper(id, loginID, firstName, middleName, lastName, email, password, shopperType);
		
		return shopper;
	}
	
	/**
	 * This method update shopper profile with its address, bill and phone data
	 * @param id
	 * @param loginID
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param shopperType
	 * @param addresses
	 * @param phones
	 * @param bills
	 */
	public void updateShopperProfile(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType, Set<Address> addresses,Set<Phone> phones, Set<Bill> bills) {
		sDAO.updateShopperProfile(id, loginID, firstName, middleName, lastName, email, password, shopperType, addresses, phones,bills);
	}
	
	/**
	 * This method update shopper data only not its address, bill or phone data
	 * @param id
	 * @param loginID
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param shopperType
	 */
	public void updateShopper(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType) {
		sDAO.updateShopper(id, loginID, firstName, middleName, lastName, email, password, shopperType);
	}
	
	/**
	 * This method deletes shopper profile with its address, bill and phone data
	 * @param id
	 */
	public void deleteShopperProfile(String id) {
		sDAO.deleteShopperProfile(id);
	}
	
	/**
	 * This method delete shopper data only not respective address, bill and phone data
	 * @param id
	 */
	public void deleteShopper(String id) {
		sDAO.deleteShopper(id);
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
	
	/**
	 * This method creates a shopper instance 
	 * @param addressID
	 * @param street
	 * @param city
	 * @param state
	 * @param zipcode
	 * @return
	 */
	public Address createAddress(String addressID, String street, String city, String state, String zipcode) {
		Address address = new Address();
		address.setAddressID(addressID);
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZipcode(zipcode);
		return address;
	}
	
	/**
	 * This method creates a phone instance
	 * @param phoneID
	 * @param type
	 * @param phoneNumber
	 * @return
	 */
	public Phone createPhone(String phoneID, String type, String phoneNumber) {
		Phone phone = new Phone();
		phone.setPhoneID(phoneID);
		phone.setType(type);
		phone.setPhoneNumber(phoneNumber);
		return phone;
	}
	
	/**
	 * This method creates bill instance
	 * @param billID
	 * @param creditCardNumber
	 * @param cvv
	 * @param expiryMonth
	 * @param expiryYear
	 * @return
	 */
	public Bill createBill(String billID, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		Bill bill = new Bill();
		bill.setBillID(billID);
		bill.setCreditCardNumber(creditCardNumber);
		bill.setCvv(cvv);
		bill.setExpiryMonth(expiryMonth);
		bill.setExpiryYear(expiryYear);
		return bill;
	}
	
	public void insertShopperAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		aDAO.insertShopperAddress(aid, pid, street, city, state, zipcode);
	}
	
	public void insertPartnerAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		aDAO.insertPartnerAddress(aid, pid, street, city, state, zipcode);
	}
	
	public void deleteShopperAddress(String id) {
		aDAO.deleteShopperAddress(id);
	}
	
	public void deletePartnerAddress(String id) {
		aDAO.deletePartnerAddress(id);
	}
	
	public void updateShopperAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		aDAO.updateShopperAddress(aid, pid, street, city, state, zipcode);
	}
	
	public void updatePartnerAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		aDAO.updatePartnerAddress(aid, pid, street, city, state, zipcode);
	}
	
}
