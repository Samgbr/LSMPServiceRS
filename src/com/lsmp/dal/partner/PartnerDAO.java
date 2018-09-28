package com.lsmp.dal.partner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.dal.product.ProductDAO;
import com.lsmp.mp.customer.Address;
import com.lsmp.mp.customer.Bill;
import com.lsmp.mp.customer.Customer;
import com.lsmp.mp.customer.Phone;
import com.lsmp.mp.partner.Partner;
import com.lsmp.mp.product.Product;

public class PartnerDAO {
	
	private ProductDAO productDAO;
	
	public PartnerDAO() {
		productDAO = new ProductDAO();
	}

	public Partner getPartner(String id) {
		String sellerLevel="";
		String sellerName="";
		Set<Product> products = new HashSet<>();
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from partner where customerID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			sellerLevel= resultSet.getString("sellerName");
			sellerName = resultSet.getString("sellerName");
			
			products = productDAO.getProducts(id);
			
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
		partner.setSellerLevel(sellerLevel);
		partner.setSellerName(sellerName);
		partner.setProducts(products);
		
		return partner;	
	}
	/*
	public Partner addPartner(String sellerLevel, String sellerType, Set<Product> products) {
		
		Partner partner = new Partner();
		
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(10000);
	    String id = "XY" + randomInt;
	    
		partner.setSellerLevel(sellerLevel);
		partner.setSellerName(sellerType);
		partner.setProducts(products);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			String insertQuery = "INSERT INTO * partner (customerID,loginID,firstName,middleName,lastName,email,password,shopperType)"
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
	}  */
}
