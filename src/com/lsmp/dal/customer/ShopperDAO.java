package com.lsmp.dal.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.dal.order.OrderDAO;
import com.lsmp.dal.product.review.ProductReviewDAO;
import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.Phone;
import com.lsmp.mp.customer.Shopper;
import com.lsmp.mp.order.Order;
import com.lsmp.mp.product.review.ProductReview;

public class ShopperDAO {
	
	private OrderDAO orderDAO;
	private ProductReviewDAO productReviewDAO;
	private AddressDAO addressDAO;
	private PhoneDAO phoneDAO;
	private BillingDAO billInfoDAO;
	
	public ShopperDAO() {
		//Initialization goes here
		addressDAO = new AddressDAO();
		phoneDAO = new PhoneDAO();
		billInfoDAO = new BillingDAO();
		orderDAO = new OrderDAO();
		productReviewDAO = new ProductReviewDAO();
	}

	//get, update, insert and delete goes here
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
	
public Shopper addShopperProfile(String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType, Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		
		Shopper shopper = new Shopper();
		
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    String id = "SH" + randomInt;
	    
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
			
			String insertQuery = "INSERT INTO * shopper (profileID,loginID,firstName,middleName,lastName,email,password,shopperType)"
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
		
		return shopper;
	}

	public void updateShopperProfile(String id,String loginID, String firstName, String middleName, String lastName,
			String email,String password,String shopperType,Set<Address> addresses,Set<Phone> phones,Set<Bill> bills) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE shopper SET loginID='"+loginID+"', firstName='"+firstName+"', middleName='"+middleName+"',lastName='"+lastName+"',email='"+email+"',password='"+password+"',shopperType='"+shopperType+"'  WHERE profileID='"+id+"')";
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
	
	public void deleteShopperProfile(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM shopper WHERE profileID='"+id+"')";
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
	

	public Shopper getShopperOrders(String id) {
		Set<Order> orders = new HashSet<>();
					
		orders = orderDAO.getOrders(id);
		
		Shopper shopper = new Shopper();
		shopper.setOrders(orders);
		return shopper;	
	
	}
	
	public Shopper getShopperReviews(String id) {
		Set<ProductReview> reviews = new HashSet<>();
					
		reviews = productReviewDAO.getProductReviews(id);
		
		Shopper shopper = new Shopper();
		shopper.setReviews(reviews);
		return shopper;	
	
	}
}
