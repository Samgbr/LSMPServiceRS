
package com.lsmp.dal.order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.lsmp.dal.DBConnect;
import com.lsmp.mp.order.OrderDetail;

public class OrderDetailDAO {

	public OrderDetail getOrderDetail(String id) {
		String orderID="";
		String productID="";
		double orderedQuantity=0.0;
		
		Connection connection = DBConnect.getDatabaseConnection();
		
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from orderDetail where orderDetailID='" + id +"'";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			resultSet.next();
			orderID= resultSet.getString("orderID");
			productID = resultSet.getString("productID");
			orderedQuantity = resultSet.getDouble("orderedQuantity");
			
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderID(orderID);
		orderDetail.setProductID(productID);
		orderDetail.setOrderedQuantity(orderedQuantity);
		return orderDetail;	
	}
	
	public Set<OrderDetail> getAllOrderDetails() {
		
		Connection connection = DBConnect.getDatabaseConnection();
		Set<OrderDetail> orderDetails = new HashSet<>();
		
		try {
			Statement selectStatement = connection.createStatement();
			
			String selectQuery = "SELECT * from orderDetail";
			ResultSet resultSet = selectStatement.executeQuery(selectQuery);
			
			while(resultSet.next()) {
				String orderDetailID = resultSet.getString("orderDetailID");
				OrderDetail orderDetail = getOrderDetail(orderDetailID);
				if(orderDetail != null) {
					orderDetails.add(orderDetail);
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
		
		return orderDetails;
		
	}

	
	
	public Set<OrderDetail> getAllOrderDetailsByOrderID(String id) {
			
			Connection connection = DBConnect.getDatabaseConnection();
			Set<OrderDetail> orderDetails = new HashSet<>();
			
			try {
				Statement selectStatement = connection.createStatement();
				
				String selectQuery = "SELECT * from orderDetail WHERE orderID='"+id+"'";
				ResultSet resultSet = selectStatement.executeQuery(selectQuery);
				
				while(resultSet.next()) {
					String orderDetailID = resultSet.getString("orderDetailID");
					OrderDetail orderDetail = getOrderDetail(orderDetailID);
					if(orderDetail != null) {
						orderDetails.add(orderDetail);
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
			
			return orderDetails;
			
		}
	
	
	public OrderDetail addOrderDetail(String odid,String orderID, String productID, double orderedQuantity) {
			
			OrderDetail orderDetail = new OrderDetail();
			/*
			Random randomGenerator = new Random();
		    int randomInt = randomGenerator.nextInt(10000);
		    String id = "OD" + randomInt; */
		    
		    orderDetail.setOrderDetailID(odid);
		    orderDetail.setOrderID(orderID);
		    orderDetail.setProductID(productID);
		    orderDetail.setOrderedQuantity(orderedQuantity);
			
			Connection connection = DBConnect.getDatabaseConnection();
			try {
				Statement insertStatement = connection.createStatement();
				
				String insertQuery = "INSERT INTO orderDetail(orderDetailID,orderID,productID,orderedQuantity) "
						+ "VALUES('"+odid+"','"+orderID+"','"+productID+"','"+orderedQuantity+"')";
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
			
			return orderDetail;
		}
	

	public void updateOrderDetail(String id, String orderID, String productID, double orderedQuantity) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			String updateQuery = "UPDATE orderDetail SET orderID='"+orderID+"', productID='"+productID+"', orderedQuantity='"+orderedQuantity+"'  WHERE orderDetailID='"+id+"'";
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
	
	public void updateOrderDetails(String id, Set<OrderDetail> details) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement updateStatement = connection.createStatement();
			
			Iterator<OrderDetail> detailsIterator = details.iterator();
			
			while(detailsIterator.hasNext()) {
				OrderDetail currentDetail = detailsIterator.next();
				updateOrderDetail(currentDetail.getOrderDetailID(),currentDetail.getOrderID(),currentDetail.getProductID(),currentDetail.getOrderedQuantity());
				//String updateQuery = "UPDATE orderDetail SET productID='"+currentDetail.getProductID()+"', orderedQuantity='"+currentDetail.getOrderedQuantity()+"'  WHERE orderID='"+id+"'";
				//updateStatement.executeUpdate(updateQuery);
				
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
	}
	
	
	public void deleteOrderDetail(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM orderDetail WHERE orderDetailID='"+id+"'";
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
	
	public void deleteOrderDetailWithOrderID(String id) {
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement deleteStatement = connection.createStatement();
			
			String deleteQuery = "DELETE FROM orderDetail WHERE orderID='"+id+"'";
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

	public void addOrderDetails(Set<OrderDetail> orderDetails) {
		
		Connection connection = DBConnect.getDatabaseConnection();
		try {
			Statement insertStatement = connection.createStatement();
			
			Iterator<OrderDetail> orderDetailsIterator = orderDetails.iterator();
			
			while(orderDetailsIterator.hasNext()) {
				/*
				Random randomGenerator = new Random();
			    int randomInt = randomGenerator.nextInt(10000);
			    String orderDetailID = "OD" + randomInt;  */
				OrderDetail currentOrderDetail = orderDetailsIterator.next();
				
				String insertQuery = "INSERT INTO orderDetail(orderDetailID,orderID,productID,orderedQuantity) "
						+ "VALUES('"+currentOrderDetail.getOrderDetailID()+"','"+currentOrderDetail.getOrderID()+"','"+currentOrderDetail.getProductID()+"','"+currentOrderDetail.getOrderedQuantity()+"')";
				insertStatement.executeUpdate(insertQuery);
				
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
	}
	
}
