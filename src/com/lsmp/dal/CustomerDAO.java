package com.lsmp.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.lsmp.mp.customer.Address;
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
	//private BillDAO billInfoDAO;
	
	public CustomerDAO() {
		//Initialization goes here
		addressDAO = new AddressDAO();
		phoneDAO = new PhoneDAO();
	}

	//get, update, insert and delete goes here
	public Customer getCustomer(String id) {
		String firstName = "";
		String middleName = "";
		String lastName = "";
		String email = "";
		Set<Address> addresses = new HashSet<>();
		Set<Phone> phones = new HashSet<>();
		//Set<Bill> billInfos = new HashSet<>();
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from customer where loginID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			
			lastName = resultSet.getString("lastName");
			middleName = resultSet.getString("middleName");
			firstName = resultSet.getString("firstName");
			email = resultSet.getString("email");
			
			addresses = addressDAO.getAddresses(id);
			phones  = phoneDAO.getPhones(id);
			
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
		customer.setFirstName(firstName);
		customer.setMiddleName(middleName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setAddresses(addresses);
		customer.setPhones(phones);
		return customer;
		
		
	}
}
