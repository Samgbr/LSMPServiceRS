package com.lsmp.dal.product;

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
import com.lsmp.mp.product.Inventory;

public class InventoryDAO {
	
	public Inventory getProductQtyOnHand(String id) {
		double qtyOnHand=0.0;
		String iid="";
		Map<String,Double> qtyOnHandMap = new HashMap<>();
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Inventory where productID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			iid = resultSet.getString("InventoryID");
			qtyOnHand= resultSet.getDouble("qtyOnHand");
			qtyOnHandMap.put(id, qtyOnHand);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		Inventory inventory = new Inventory();
		inventory.setInventoryID(iid);
		inventory.setQtyOnHandMap(qtyOnHandMap);
		inventory.setQty(qtyOnHand);
		
		return inventory;	
	}
	
	public Set<Inventory> getAllProductsQtyOnHand() {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<Inventory> inventories = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Inventory";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String productID = resultSet.getString("productID");
				Inventory inventory = getProductQtyOnHand(productID);
				if(inventory != null) {
					inventories.add(inventory);
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
		
		return inventories;
		
	}
	/*
	public Inventory getSmartphoneQtyOnHand(String id) {
		double qtyOnHand=0.0;
		String iid="";
		Map<String,Double> qtyOnHandMap = new HashMap<>();
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from Inventory where smartphoneProductID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			iid = resultSet.getString("InventoryID");
			qtyOnHand= resultSet.getDouble("qtyOnHand");
			qtyOnHandMap.put(id, qtyOnHand);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		Inventory inventory = new Inventory();
		inventory.setInventoryID(iid);
		inventory.setQtyOnHandMap(qtyOnHandMap);
		
		return inventory;	
	}   */
	
	public Inventory addProductQtyOnHand(String iid, String bid, double qtyOnHand) {
			
			Map<String,Double> qtyOnHandMap = new HashMap<>();
			
			Inventory inventory = new Inventory();
		    qtyOnHandMap.put(bid, qtyOnHand);
			
			inventory.setQtyOnHandMap(qtyOnHandMap);
			
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				
				Statement insertStatement = connection.createStatement();
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String iID = "IN" + randomInt; */
				
				String insertQuery = "INSERT INTO Inventory(InventoryID,productID,qtyOnHand) "
						+ "VALUES('"+iid+"','"+bid+"','"+qtyOnHand+"')";
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
			
			return inventory;
		}
	/*
	public Inventory addSmartphoneQtyOnHand(String iid, String spid, double qtyOnHand) {
		
		Map<String,Double> qtyOnHandMap = new HashMap<>();
		
		Inventory inventory = new Inventory();
	    qtyOnHandMap.put(spid, qtyOnHand);
		
		inventory.setQtyOnHandMap(qtyOnHandMap);
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			
			Statement insertStatement = connection.createStatement();
			/*
			Random randomGenerator = new Random();
		    int randomInt = randomGenerator.nextInt(10000);
		    String iID = "IN" + randomInt; */
			/*
			String insertQuery = "INSERT INTO Inventory(InventoryID,smartphoneProductID,qtyOnHand) "
					+ "VALUES('"+iid+"','"+spid+"','"+qtyOnHand+"')";
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
		
		return inventory;
	}  */
	
	public void updateProductQtyOnHand(String id, double qtyOnHand) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE Inventory SET qtyOnHand='"+qtyOnHand+"'  WHERE productID='"+id+"'";
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
	/*
	public void updateSmartphoneQtyOnHand(String id, double qtyOnHand) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE Inventory SET qtyOnHand='"+qtyOnHand+"'  WHERE smartphoneProductID='"+id+"'";
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
	}  */
	
	public void deleteProductQtyOnHand(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM Inventory WHERE productID='"+id+"'";
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
	/*
	public void deleteSmartphoneQtyOnHand(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM Inventory WHERE smartphoneProductID='"+id+"'";
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
	}  */
}
