package com.lsmp.mp.order.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.order.OrderDetail;
import com.lsmp.mp.order.OrderManager;
import com.lsmp.mp.order.service.representation.BookOrderDetailRepresentation;

public class BookOrderDetailActivity {

	private static OrderManager orderManager = new OrderManager();
	
	public BookOrderDetailRepresentation getBookOrderDetail(String id) {
		
		OrderDetail orderDetail = orderManager.getBookOrderDetail(id);
		
		BookOrderDetailRepresentation bookOrderDetailRepresentation = new BookOrderDetailRepresentation();
		
		bookOrderDetailRepresentation.setOrderDetailID(orderDetail.getOrderDetailID());
		bookOrderDetailRepresentation.setBookProductID(orderDetail.getBookProductID());
		bookOrderDetailRepresentation.setOrderID(orderDetail.getOrderID());
		bookOrderDetailRepresentation.setOrderedQuantity(orderDetail.getOrderedQuantity());
		
		return bookOrderDetailRepresentation;
	}

	public Set<BookOrderDetailRepresentation> getBookOrderDetails() {
		
		Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();
		Set<BookOrderDetailRepresentation> bookOrderDetailRepresentations = new HashSet<BookOrderDetailRepresentation>();
		
		orderDetails = orderManager.getAllBookOrderDetails();
		
		Iterator<OrderDetail> it = orderDetails.iterator();
		while(it.hasNext()) {
          OrderDetail orderDetail = (OrderDetail)it.next();
          
          BookOrderDetailRepresentation bookOrderDetailRepresentation = new BookOrderDetailRepresentation();
  		
  		  bookOrderDetailRepresentation.setOrderDetailID(orderDetail.getOrderDetailID());
  		  bookOrderDetailRepresentation.setBookProductID(orderDetail.getBookProductID());
  		  bookOrderDetailRepresentation.setOrderID(orderDetail.getOrderID());
  		  bookOrderDetailRepresentation.setOrderedQuantity(orderDetail.getOrderedQuantity());
          
          //now add this representation in the list
  		bookOrderDetailRepresentations.add(bookOrderDetailRepresentation);
        }
		return bookOrderDetailRepresentations;
	}

	public BookOrderDetailRepresentation createBookOrderDetail(String odid, String orderID, String pid, double orderedQuantity) {
		
		OrderDetail orderDetail = orderManager.addBookOrderDetail(odid, orderID, pid, orderedQuantity);
		
		BookOrderDetailRepresentation bookOrderDetailRepresentation = new BookOrderDetailRepresentation();
  		
		  bookOrderDetailRepresentation.setOrderDetailID(orderDetail.getOrderDetailID());
		  bookOrderDetailRepresentation.setBookProductID(orderDetail.getBookProductID());
		  bookOrderDetailRepresentation.setOrderID(orderDetail.getOrderID());
		  bookOrderDetailRepresentation.setOrderedQuantity(orderDetail.getOrderedQuantity());
        
		return bookOrderDetailRepresentation;
	}

	public String updateBookOrderDetail(String odid, String orderID, String pid, double orderedQuantity) {
		orderManager.updateBookOrderDetail(odid, orderID, pid, orderedQuantity);
		return "OK";
	}

	public String deleteBookOrderDetail(String id) {
		orderManager.deleteOrderDetail(id);
		return "OK";
	}

}
