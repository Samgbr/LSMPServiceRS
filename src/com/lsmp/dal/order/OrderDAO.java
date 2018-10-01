package com.lsmp.dal.order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.order.Order;
import com.lsmp.mp.order.OrderDetail;

public class OrderDAO {
	
	private OrderDetailDAO orderDetailDAO; 
	
	public OrderDAO() {
		orderDetailDAO = new OrderDetailDAO();
	}
	
	public Order getOrderWithDetail(String id) {
		String profileID="";
		String orderDate="";
		String shipAddressID="";
		Set<OrderDetail> orderDetails = new HashSet<>();
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from orderT where orderID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			profileID= resultSet.getString("profileID");
			orderDate = resultSet.getString("orderDate");
			shipAddressID = resultSet.getString("shipAddressID");
			
			orderDetails = orderDetailDAO.getAllOrderDetailsByOrderID(id);
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		Order order = new Order();
		order.setOrderID(id);
		order.setProfileID(profileID);
		order.setOrderDate(orderDate);
		order.setShipAddressID(shipAddressID);
		order.setOrderDetails(orderDetails);
		return order;	
	}
	
	public Order addOrder(String profileID, String orderDate, String shipAddressID, Set<OrderDetail> orderDetails) {
			
			Order order = new Order();
			
			Random randomGenerator = new Random();
		    int randomInt = randomGenerator.nextInt(10000);
		    String id = "OR" + randomInt;
		    
		    order.setOrderID(id);
		    order.setOrderDate(orderDate);
		    order.setProfileID(profileID);
		    order.setShipAddressID(shipAddressID);
		    order.setOrderDetails(orderDetails);
			
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				
				String insertQuery = "INSERT INTO * orderT (orderID,profileID,orderDate,shipAddressID,refund,isPicked,isPacked,deliveredToPickUpLocation,isDelivered,pickUpLocation)"
						+ "VALUES('"+id+"','"+profileID+"','"+orderDate+"','"+shipAddressID+"','false','false','false','false','false','NA')";
				insertStatement.executeUpdate(insertQuery);
			
				orderDetailDAO.addOrderDetails(orderDetails);
				
			}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				if(connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {}
				}
			}
			
			return order;
		}

	public void updateOrder(String id, String profileID, String orderDate, String shipAddressID) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE orderT SET profileID='"+profileID+"', orderDate='"+orderDate+"', shipAddressID='"+shipAddressID+"'  WHERE orderID='"+id+"')";
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
	
	public void deleteOrder(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM orderT WHERE orderID='"+id+"')";
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
