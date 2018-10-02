package com.lsmp.dal.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.product.Smartphone;

public class SmartphoneDAO {

	//get, update, insert and delete goes here
	public Smartphone getSmartphone(String id) {
		String productName="";
		String description="";
		double purchasePrice=0.0;
		double sellingPrice=0.0;
		double discount=0.0;
		String displayInch="";
		String brand = "";
		String ramSize = "";
		String os = "";
		String storageSize = "";
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from smartphone where productID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			productName= resultSet.getString("productName");
			description = resultSet.getString("description");
			purchasePrice = resultSet.getDouble("purchasePrice");
			sellingPrice = resultSet.getDouble("sellingPrice");
			discount = resultSet.getDouble("discount");
			displayInch = resultSet.getString("displayInch");
			brand = resultSet.getString("brand");
			ramSize = resultSet.getString("ramSize");
			os = resultSet.getString("os");
			storageSize = resultSet.getString("storageSize");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		Smartphone smartphone = new Smartphone();
		smartphone.setProductName(productName);
		smartphone.setDescription(description);
		smartphone.setPurchasePrice(purchasePrice);
		smartphone.setSellingPrice(sellingPrice);
		smartphone.setDiscount(discount);
		smartphone.setDisplayInch(displayInch);
		smartphone.setBrand(brand);
		smartphone.setRamSize(ramSize);
		smartphone.setOs(os);
		smartphone.setStorageSize(storageSize);
		return smartphone;	
	}
	
	public Set<Smartphone> getAllSmartphones() {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Smartphone> smartphones = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from smartphone";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String productID = resultSet.getString("productID");
				Smartphone smartphone = getSmartphone(productID);
				if(smartphone != null) {
					smartphones.add(smartphone);
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
		
		return smartphones;
		
	}
	
	public Smartphone addSmartphone(String productName, String description, double purchasePrice, double sellingPrice, 
				double discount, String displayInch, String brand, String ramSize, String os, String storageSize) {
			
			Smartphone smartphone = new Smartphone();
			
			Random randomGenerator = new Random();
		    int randomInt = randomGenerator.nextInt(10000);
		    String id = "SP" + randomInt;
		    
		    smartphone.setProductID(id);
		    smartphone.setProductName(productName);
		    smartphone.setDescription(description);
		    smartphone.setPurchasePrice(purchasePrice);
		    smartphone.setSellingPrice(sellingPrice);
		    smartphone.setDiscount(discount);
		    smartphone.setDisplayInch(displayInch);
		    smartphone.setBrand(brand);
		    smartphone.setRamSize(ramSize);
		    smartphone.setOs(os);
		    smartphone.setStorageSize(storageSize);
			
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				
				String insertQuery = "INSERT INTO smartphone(productID,displayInch,brand,ramSize,os,storageSize,productName,description,purchasePrice,sellingPrice,discount) "
						+ "VALUES('"+id+"','"+displayInch+"','"+brand+"','"+ramSize+"','"+os+"','"+storageSize+"','"+productName+"','"+description+"','"+purchasePrice+"','"+sellingPrice+"','"+discount+"')";
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
			
			return smartphone;
		}

	public void updateSmartphone(String id, String productName, String description, double purchasePrice, double sellingPrice, 
			double discount, String displayInch, String brand, String ramSize, String os, String storageSize) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE smartphone SET productName='"+productName+"', description='"+description+"', purchasePrice='"+purchasePrice+"',sellingPrice='"+sellingPrice+"',discount='"+discount+"',displayInch='"+displayInch+"',brand='"+brand+"',ramSize='"+ramSize+"',os='"+os+"',storageSize='"+storageSize+"'  WHERE productID='"+id+"')";
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
	
	public void deleteSmartphone(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM smartphone WHERE productID='"+id+"')";
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
