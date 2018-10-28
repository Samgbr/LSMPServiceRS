package com.lsmp.dal.partner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.partner.PartnerProduct;

public class PartnerProductDAO {

	public PartnerProduct getPartnerBookProfileBYProductID(String id) {
		String profileID="";
		String productPartnerID="";
		Map<String,String> partnerProductMap = new HashMap<>();
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from productPartner where bookProductID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			productPartnerID = resultSet.getString("productPartnerID");
			profileID= resultSet.getString("profileID");
			partnerProductMap.put(id, profileID);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		PartnerProduct partnerProduct = new PartnerProduct();
		partnerProduct.setPartnerProduct(partnerProductMap);
		partnerProduct.setProductPartnerID(productPartnerID);
		
		return partnerProduct;	
	}
	
	public PartnerProduct getPartnerSmarphoneProfileBYProductID(String id) {
		String profileID="";
		
		Map<String,String> partnerProductMap = new HashMap<>();
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from productPartner where smartphoneProductID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			profileID= resultSet.getString("profileID");
			partnerProductMap.put(id, profileID);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		PartnerProduct partnerProduct = new PartnerProduct();
		partnerProduct.setPartnerProduct(partnerProductMap);
		
		return partnerProduct;	
	}
	
	public Set<PartnerProduct> getAllPartnerBooks() {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<PartnerProduct> partnerProducts = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from productPartner";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String productID = resultSet.getString("bookProductID");
				PartnerProduct partnerProduct = getPartnerBookProfileBYProductID(productID);
				if(partnerProduct != null) {
					partnerProducts.add(partnerProduct);
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
		
		return partnerProducts;
		
	}
	
	public PartnerProduct addPartnerBook(String ppid, String id, String profileID) {
			
		Map<String,String> partnerProductMap = new HashMap<>();
			
			PartnerProduct partnerProduct = new PartnerProduct();
		    
			partnerProductMap.put(id, profileID);
			
			partnerProduct.setPartnerProduct(partnerProductMap);
			
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String pid = "PP" + randomInt;  */
				
				String insertQuery = "INSERT INTO productPartner(productPartnerID,bookProductID,profileID) "
						+ "VALUES('"+ppid+"','"+id+"','"+profileID+"')";
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
			
			return partnerProduct;
		}
	
	public PartnerProduct addPartnerSmartphone(String ppid, String id, String profileID) {
		
		Map<String,String> partnerProductMap = new HashMap<>();
			
			PartnerProduct partnerProduct = new PartnerProduct();
		    
			partnerProductMap.put(id, profileID);
			
			partnerProduct.setPartnerProduct(partnerProductMap);
			
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String pid = "PP" + randomInt;  */
				
				String insertQuery = "INSERT INTO productPartner(productPartnerID,smartphoneProductID,profileID) "
						+ "VALUES('"+ppid+"','"+id+"','"+profileID+"')";
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
			
			return partnerProduct;
		}

	public void updatePartnerBook(String id, String profileID) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE productPartner SET profileID='"+profileID+"'  WHERE bookProductID='"+id+"'";
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
	
	public void updatePartnerSmartphone(String id, String profileID) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE productPartner SET profileID='"+profileID+"'  WHERE smartphoneProductID='"+id+"'";
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
	
	public void deletePartnerBook(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM productPartner WHERE bookProductID='"+id+"'";
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
	
	public void deletePartnerSmartphone(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM productPartner WHERE smartphoneProductID='"+id+"'";
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
