package com.lsmp.dal.partner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.dal.customer.AddressDAO;
import com.lsmp.dal.customer.BillingDAO;
import com.lsmp.dal.customer.PhoneDAO;
import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.Phone;
import com.lsmp.mp.partner.Partner;

public class PartnerDAO {
	
	private AddressDAO addressDAO;
	private PhoneDAO phoneDAO;
	private BillingDAO billInfoDAO;
	
	public PartnerDAO() {
		addressDAO = new AddressDAO();
		phoneDAO = new PhoneDAO();
		billInfoDAO = new BillingDAO();
	}
	
	//get, update, insert and delete goes here
		public Partner getPartnerProfile(String id) {
			String loginID="";
			String firstName = "";
			String middleName = "";
			String lastName = "";
			String email = "";
			String sellerLevel="";
			String sellerName="";
			Set<Address> addresses = new HashSet<>();
			Set<Phone> phones = new HashSet<>();
			Set<Bill> billInfos = new HashSet<>();
			Connection connection = DBConnect.getDatabaseConnection();
			
			
			try {
				Statement selectStatement = connection.createStatement();
				
				String selectQuery = "SELECT * from partner where profileID='" + id +"'";
				ResultSet resultSet = selectStatement.executeQuery(selectQuery);
				resultSet.next();
				loginID= resultSet.getString("loginID");
				lastName = resultSet.getString("lastName");
				middleName = resultSet.getString("middleName");
				firstName = resultSet.getString("firstName");
				email = resultSet.getString("email");
				sellerLevel = resultSet.getString("sellerLevel");
				sellerName = resultSet.getString("sellerName");
				
				addresses = addressDAO.getAddresses(id);
				phones  = phoneDAO.getPhones(id);
				billInfos = billInfoDAO.getBillingInfos(id);
				
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				if(connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {}
				}
			}
			Partner partner = new Partner();
			partner.setLoginID(loginID);
			partner.setFirstName(firstName);
			partner.setMiddleName(middleName);
			partner.setLastName(lastName);
			partner.setEmail(email);
			partner.setSellerLevel(sellerLevel);
			partner.setSellerName(sellerName);
			partner.setAddresses(addresses);
			partner.setPhones(phones);
			partner.setBillingsInfo(billInfos);
			return partner;	
		}
		
		public Set<Partner> getAllPartnerProfiles() {
			
			Connection connection = DBConnect.getDatabaseConnection();
			Set<Partner> partners = new HashSet<>();
			
			try {
				Statement selectStatement = connection.createStatement();
				
				String selectQuery = "SELECT * from partner";
				ResultSet resultSet = selectStatement.executeQuery(selectQuery);
				
				while(resultSet.next()) {
					String profileID = resultSet.getString("profileID");
					Partner partner = getPartnerProfile(profileID);
					if(partner != null) {
						partners.add(partner);
					}
				}
				
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				if(connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {}
				}
			}
			
			return partners;
			
		}
		
	public Partner addPartnerProfile(String pid, String loginID, String firstName, String middleName, String lastName,
				String email,String password,String sellerLevel, String sellerName, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
			
			Partner partner = new Partner();
			/*
			Random randomGenerator = new Random();
		    int randomInt = randomGenerator.nextInt(10000);
		    String id = "PA" + randomInt; */
		    
			partner.setProfileID(pid);
			partner.setLoginID(loginID);
			partner.setFirstName(firstName);
			partner.setMiddleName(middleName);
			partner.setLastName(lastName);
			partner.setEmail(email);
			partner.setPassword(password);
			partner.setSellerLevel(sellerLevel);
			partner.setSellerName(sellerName);
			partner.setAddresses(addresses);
			partner.setPhones(phones);
			partner.setBillingsInfo(bills);
			
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				
				String insertQuery = "INSERT INTO * partner (profileID,loginID,firstName,middleName,lastName,email,p_password,sellerLevel,sellerName)"
						+ "VALUES('"+pid+"','"+loginID+"','"+firstName+"','"+middleName+"','"+lastName+"','"+email+"','"+password+"','"+sellerLevel+"','"+sellerName+"')";
				insertStatement.executeUpdate(insertQuery);
				
				addressDAO.insertAddresses(pid, addresses);
				phoneDAO.insertPhones(pid, phones);
				billInfoDAO.insertBillingInfos(pid, bills);
			
				
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				if(connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {}
				}
			}
			
			return partner;
		}

		public void updatePartnerProfile(String id,String loginID, String firstName, String middleName, String lastName,
				String email,String password,String sellerLevel, String sellerName, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement updateStatement = connection.createStatement();
				
				String updateQuery = "UPDATE partner SET loginID='"+loginID+"', firstName='"+firstName+"', middleName='"+middleName+"',lastName='"+lastName+"',email='"+email+"',p_password='"+password+"',sellerLevel='"+sellerLevel+"',sellerName='"+sellerName+"'  WHERE profileID='"+id+"')";
				updateStatement.executeUpdate(updateQuery);	
				addressDAO.updateAddresses(id, addresses);
				phoneDAO.updatePhones(id, phones);
				billInfoDAO.updateBillingInfos(id, bills);
				
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				if(connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {}
				}
			}
		}
		
		public void deletePartnerProfile(String id) {
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement deleteStatement = connection.createStatement();
				
				String deleteQuery = "DELETE FROM partner WHERE profileID='"+id+"')";
				deleteStatement.executeUpdate(deleteQuery);	
				
				addressDAO.deleteAddress(id);
				phoneDAO.deletePhone(id);
				billInfoDAO.deleteBillingInfo(id);
				
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				if(connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {}
				}
			}
		}
		
		
		 
	
}
