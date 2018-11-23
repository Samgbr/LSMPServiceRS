package com.lsmp.mp.customer;

import java.util.Set;

import com.lsmp.dal.customer.AddressDAO;
import com.lsmp.dal.customer.BillingDAO;
import com.lsmp.dal.customer.PhoneDAO;
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
	private static BillingDAO bDAO = new BillingDAO();
	private static PhoneDAO pDAO = new PhoneDAO();
	
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
	
	public Set<Shopper> getAllShopperProfiles() {
		return sDAO.getAllShopperProfiles();
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
	public Shopper addShopperProfile(String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		
		Shopper shopper = sDAO.addShopperProfile(loginID, firstName, middleName, lastName, email, password, shopperType,addresses, phones,bills);
		
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
	
	public Address insertShopperAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		return aDAO.insertShopperAddress(aid, pid, street, city, state, zipcode);
	}
	public Phone insertShopperPhone(String pid, String id, String type, String phoneNumber) {
		return pDAO.insertShopperPhone(pid, id, type, phoneNumber);
	}
	public Phone insertPartnerPhone(String pid, String id, String type, String phoneNumber) {
		return pDAO.insertPartnerPhone(pid, id, type, phoneNumber);
	}
	public Address insertPartnerAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		return aDAO.insertPartnerAddress(aid, pid, street, city, state, zipcode);
	}
	
	public Bill insertPartnerBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		return bDAO.insertPartnerBillingInfo(bid, id, creditCardNumber, cvv, expiryMonth, expiryYear);
	}
	
	public Bill insertShopperBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		return bDAO.insertShopperBillingInfo(bid, id, creditCardNumber, cvv, expiryMonth, expiryYear);
	}
	
	public void deleteShopperAddress(String id) {
		aDAO.deleteShopperAddress(id);
	}
	public void deleteShopperPhone(String id) {
		pDAO.deleteShopperPhone(id);
	}
	public void deletePartnerPhone(String id) {
		pDAO.deletePartnerPhone(id);
	}
	
	public Address getShopperAddress(String id) {
		return aDAO.getShopperAddress(id);
	}
	
	public Set<Address> getShopperAddresses(String id) {
		return aDAO.getShopperAddresses(id);
	}
	public Address getPartnerAddress(String id) {
		return aDAO.getPartnerAddress(id);
	}
	public Set<Address> getPartnerAddresses(String id) {
		return aDAO.getPartnerAddresses(id);
	}
	public Bill getShopperBillingInfo(String id) {
		return bDAO.getShopperBillingInfo(id);
	}
	public Set<Bill> getShopperBillingInfos(String id) {
		return bDAO.getShopperBillingInfos(id);
	}
	
	public Bill getPartnerBillingInfo(String id) {
		return bDAO.getPartnerBillingInfo(id);
	}
	public Set<Bill> getPartnerBillingInfos(String id) {
		return bDAO.getPartnerBillingInfos(id);
	}
	
	public Phone getShopperPhone(String id) {
		return pDAO.getShopperPhone(id);
	}
	public Set<Phone> getShopperPhones(String id) {
		return pDAO.getShopperPhones(id);
	}
	public Phone getPartnerPhone(String id) {
		return pDAO.getPartnerPhone(id);
	}
	public Set<Phone> getPartnerPhones(String id) {
		return pDAO.getPartnerPhones(id);
	}
	public void deletePartnerAddress(String id) {
		aDAO.deletePartnerAddress(id);
	}
	
	public void deletePartnerBillingInfo(String id) {
		bDAO.deletePartnerBillingInfo(id);
	}
	public void deleteShopperBillingInfo(String id) {
		bDAO.deleteShopperBillingInfo(id);
	}
	
	public void updateShopperAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		aDAO.updateShopperAddress(aid, pid, street, city, state, zipcode);
	}
	
	public void updateShopperBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		bDAO.updateShopperBillingInfo(bid, id, creditCardNumber, cvv, expiryMonth, expiryYear);
	}
	
	public void updatePartnerAddress(String aid, String pid, String street, String city, String state, String zipcode) {
		aDAO.updatePartnerAddress(aid, pid, street, city, state, zipcode);
	}
	public void updateShopperPhone(String pid, String id, String type, String phoneNumber) {
		pDAO.updateShopperPhone(pid, id, type, phoneNumber);
	}
	public void updatePartnerPhone(String pid, String id, String type, String phoneNumber) {
		pDAO.updatePartnerPhone(pid, id, type, phoneNumber);
	}
	public void updatePartnerBillingInfo(String bid, String id, String creditCardNumber, int cvv, int expiryMonth, int expiryYear) {
		bDAO.updatePartnerBillingInfo(bid, id, creditCardNumber, cvv, expiryMonth, expiryYear);
	}
	
}
