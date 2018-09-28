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
import com.lsmp.mp.customer.Customer;
import com.lsmp.mp.customer.Phone;

/**
 * This class is used to as a data access layer for Customer
 * @author samzi
 *
 */

public class CustomerDAO {
	
	private AddressDAO addressDAO;
	private PhoneDAO phoneDAO;
	private BillingDAO billInfoDAO;
	
	public CustomerDAO() {
		//Initialization goes here
		addressDAO = new AddressDAO();
		phoneDAO = new PhoneDAO();
		billInfoDAO = new BillingDAO();
	}

	//get, update, insert and delete goes here
	public Customer getCustomer(String id) {
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
			
			String selectQuery = "SELECT * from customer where customerID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			loginID= resultSet.getString("loginID");
			lastName = resultSet.getString("lastName");
			middleName = resultSet.getString("middleName");
			firstName = resultSet.getString("firstName");
			email = resultSet.getString("email");
			shopperType = resultSet.getString("shopperType");
			
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
		Customer customer = new Customer();
		customer.setLoginID(loginID);
		customer.setFirstName(firstName);
		customer.setMiddleName(middleName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setShopperType(shopperType);
		customer.setAddresses(addresses);
		customer.setPhones(phones);
		customer.setBillingsInfo(billInfos);
		return customer;	
	}
	
	public Set<Customer> getAllCustomers() {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Customer> customers = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from customer";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String customerID = resultSet.getString("customerID");
				Customer customer = getCustomer(customerID);
				if(customer != null) {
					customers.add(customer);
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
		
		return customers;
		
	}
	
public Customer addCustomer(String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		
		Customer customer = new Customer();
		
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    String id = "XY" + randomInt;
	    
		customer.setCustomerID(id);
		customer.setLoginID(loginID);
		customer.setFirstName(firstName);
		customer.setMiddleName(middleName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setShopperType(shopperType);
		customer.setAddresses(addresses);
		customer.setPhones(phones);
		customer.setBillingsInfo(bills);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO * customer (customerID,loginID,firstName,middleName,lastName,email,password,shopperType)"
					+ "VALUES('"+id+"','"+loginID+"','"+firstName+"','"+middleName+"','"+lastName+"','"+email+"','"+password+"','"+shopperType+"')";
			insertStatement.executeUpdate(insertQuery);
			
			addressDAO.insertAddresses(id, addresses);
			phoneDAO.insertPhones(id, phones);
			billInfoDAO.insertBillingInfos(id, bills);
		
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return customer;
	}

	public void updateCustomer(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType,Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE customer SET loginID='"+loginID+"', firstName='"+firstName+"', middleName='"+middleName+"',lastName='"+lastName+"',email='"+email+"',password='"+password+"',shopperType='"+shopperType+"'  WHERE customerID='"+id+"')";
			updateStatement.executeUpdate(updateQuery);	
			addressDAO.updateAddress(id, addresses);
			phoneDAO.updatePhone(id, phones);
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
	
	public void deleteCustomer(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM customer WHERE customerID='"+id+"')";
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
