package com.lsmp.dal.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.lsmp.dal.DBConnect;

import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.Phone;
import com.lsmp.mp.customer.Shopper;

public class ShopperDAO {
	
	private AddressDAO addressDAO;
	private PhoneDAO phoneDAO;
	private BillingDAO billInfoDAO;
	
	public ShopperDAO() {
		//Initialization goes here
		addressDAO = new AddressDAO();
		phoneDAO = new PhoneDAO();
		billInfoDAO = new BillingDAO();
	}

	//get, update, insert and delete goes here
	/**
	 * This method get the whole shopper profile including its shopper address, bill and phone info
	 * @param id - profileID
	 * @return - shopper model
	 */
	public Shopper getShopperProfile(String id) {
		String loginID="";
		String firstName = "";
		String middleName = "";
		String lastName = "";
		String email = "";
		String shopperType="";
		Set<Address> addresses = new HashSet<>();
		Set<Phone> phones = new HashSet<>();
		Set<Bill> billInfos = new HashSet<>();
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from shopper where profileID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			loginID= resultSet.getString("loginID");
			lastName = resultSet.getString("lastName");
			middleName = resultSet.getString("middleName");
			firstName = resultSet.getString("firstName");
			email = resultSet.getString("email");
			shopperType = resultSet.getString("shopperType");
			
			addresses = addressDAO.getShopperAddresses(id);
			phones  = phoneDAO.getShopperPhones(id);
			billInfos = billInfoDAO.getShopperBillingInfos(id);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		Shopper shopper = new Shopper();
		shopper.setLoginID(loginID);
		shopper.setFirstName(firstName);
		shopper.setMiddleName(middleName);
		shopper.setLastName(lastName);
		shopper.setEmail(email);
		shopper.setShopperType(shopperType);
		shopper.setAddresses(addresses);
		shopper.setPhones(phones);
		shopper.setBillingsInfo(billInfos);
		return shopper;	
	}
	
	/**
	 * This method only get shopper profile only
	 * @param id - profileID
	 * @return - shopper model
	 */
	public Shopper getShopper(String id) {
		String loginID="";
		String firstName = "";
		String middleName = "";
		String lastName = "";
		String email = "";
		String shopperType="";
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from shopper where profileID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			loginID= resultSet.getString("loginID");
			lastName = resultSet.getString("lastName");
			middleName = resultSet.getString("middleName");
			firstName = resultSet.getString("firstName");
			email = resultSet.getString("email");
			shopperType = resultSet.getString("shopperType");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		Shopper shopper = new Shopper();
		shopper.setLoginID(loginID);
		shopper.setFirstName(firstName);
		shopper.setMiddleName(middleName);
		shopper.setLastName(lastName);
		shopper.setEmail(email);
		shopper.setShopperType(shopperType);
		return shopper;	
	}
	
	/**
	 * This method get all shopper profiles with bill, address and phone info
	 * @return - set of shopper models
	 */
	public Set<Shopper> getAllShopperProfiles() {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Shopper> shoppers = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from shopper";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String profileID = resultSet.getString("profileID");
				Shopper shopper = getShopperProfile(profileID);
				if(shopper != null) {
					shoppers.add(shopper);
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
		
		return shoppers;
		
	}
	
	/**
	 * This method will add shopper with its address, bill and phone info
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
		
		Shopper shopper = new Shopper();
		/*
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    String id = "SH" + randomInt;  */
	    
		shopper.setProfileID(id);
		shopper.setLoginID(loginID);
		shopper.setFirstName(firstName);
		shopper.setMiddleName(middleName);
		shopper.setLastName(lastName);
		shopper.setEmail(email);
		shopper.setPassword(password);
		shopper.setShopperType(shopperType);
		shopper.setAddresses(addresses);
		shopper.setPhones(phones);
		shopper.setBillingsInfo(bills);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO shopper(profileID,loginID,firstName,middleName,lastName,email,s_password,shopperType) "
					+ "VALUES('"+id+"','"+loginID+"','"+firstName+"','"+middleName+"','"+lastName+"','"+email+"','"+password+"','"+shopperType+"')";
			insertStatement.executeUpdate(insertQuery);
			
			addressDAO.insertShopperAddresses(id, addresses);
			phoneDAO.insertShopperPhones(id, phones);
			billInfoDAO.insertShopperBillingInfos(id, bills);
		
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return shopper;
	}
	
	/**
	 * This method will add shopper data only
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
		
		Shopper shopper = new Shopper();
		/*
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    String id = "SH" + randomInt;  */
	    
		shopper.setProfileID(id);
		shopper.setLoginID(loginID);
		shopper.setFirstName(firstName);
		shopper.setMiddleName(middleName);
		shopper.setLastName(lastName);
		shopper.setEmail(email);
		shopper.setPassword(password);
		shopper.setShopperType(shopperType);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO shopper(profileID,loginID,firstName,middleName,lastName,email,s_password,shopperType) "
					+ "VALUES('"+id+"','"+loginID+"','"+firstName+"','"+middleName+"','"+lastName+"','"+email+"','"+password+"','"+shopperType+"')";
			insertStatement.executeUpdate(insertQuery);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return shopper;
	}
	
	/**
	 * This method will update the shopper profile with bill, address and phone data
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
			String email,String password,String shopperType,Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE shopper SET loginID='"+loginID+"', firstName='"+firstName+"', middleName='"+middleName+"',lastName='"+lastName+"',email='"+email+"',s_password='"+password+"',shopperType='"+shopperType+"'  WHERE profileID='"+id+"'";
			updateStatement.executeUpdate(updateQuery);	
			addressDAO.updateShopperAddresses(id, addresses);
			phoneDAO.updateShopperPhones(id, phones);
			billInfoDAO.updateShopperBillingInfos(id, bills);
			
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
	
	/**
	 * This method update shopper data only
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
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE shopper SET loginID='"+loginID+"', firstName='"+firstName+"', middleName='"+middleName+"',lastName='"+lastName+"',email='"+email+"',s_password='"+password+"',shopperType='"+shopperType+"'  WHERE profileID='"+id+"'";
			updateStatement.executeUpdate(updateQuery);	
			
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
	
	/**
	 * This method deletes shopper profile with bill, address and phone data
	 * @param id - profileID
	 */
	public void deleteShopperProfile(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM shopper WHERE profileID='"+id+"'";
			deleteStatement.executeUpdate(deleteQuery);	
			
			addressDAO.deleteShopperAddress(id);
			phoneDAO.deleteShopperPhone(id);
			billInfoDAO.deleteShopperBillingInfo(id);
			
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
	
	/**
	 * This method deletes shopper data only
	 * @param id
	 */
	public void deleteShopper(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM shopper WHERE profileID='"+id+"'";
			deleteStatement.executeUpdate(deleteQuery);	
			
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
