package com.lsmp.mp.order.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.lsmp.mp.order.OrderDetail;
import com.lsmp.mp.order.OrderManager;
import com.lsmp.mp.order.service.representation.SmartphoneOrderDetailRepresentation;

public class SmartphoneOrderDetailActivity {
	
	private static OrderManager orderManager = new OrderManager();

	public SmartphoneOrderDetailRepresentation getSmartphoneOrderDetail(String id) {
		
		OrderDetail orderDetail = orderManager.getSmartphoneOrderDetail(id);
		
		SmartphoneOrderDetailRepresentation smartphoneOrderDetailRepresentation = new SmartphoneOrderDetailRepresentation();
		
		smartphoneOrderDetailRepresentation.setOrderDetailID(orderDetail.getOrderDetailID());
		smartphoneOrderDetailRepresentation.setSmartphoneProductID(orderDetail.getSmartphoneProductID());
		smartphoneOrderDetailRepresentation.setOrderID(orderDetail.getOrderID());
		smartphoneOrderDetailRepresentation.setOrderedQuantity(orderDetail.getOrderedQuantity());
		
		return smartphoneOrderDetailRepresentation;
	}

	public Set<SmartphoneOrderDetailRepresentation> getAllSmartphoneOrderDetails() {
		
		Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();
		Set<SmartphoneOrderDetailRepresentation> smartphoneOrderDetailRepresentations = new HashSet<SmartphoneOrderDetailRepresentation>();
		
		orderDetails = orderManager.getAllSmartphoneOrderDetails();
		
		Iterator<OrderDetail> it = orderDetails.iterator();
		while(it.hasNext()) {
          OrderDetail orderDetail = (OrderDetail)it.next();
          
          SmartphoneOrderDetailRepresentation smartphoneOrderDetailRepresentation = new SmartphoneOrderDetailRepresentation();
  		
  		  smartphoneOrderDetailRepresentation.setOrderDetailID(orderDetail.getOrderDetailID());
  		  smartphoneOrderDetailRepresentation.setSmartphoneProductID(orderDetail.getSmartphoneProductID());
  		  smartphoneOrderDetailRepresentation.setOrderID(orderDetail.getOrderID());
  		  smartphoneOrderDetailRepresentation.setOrderedQuantity(orderDetail.getOrderedQuantity());
          
          //now add this representation in the list
  		smartphoneOrderDetailRepresentations.add(smartphoneOrderDetailRepresentation);
        }
		return smartphoneOrderDetailRepresentations;
	}

	public SmartphoneOrderDetailRepresentation addSmartphoneOrderDetail(String odid, String orderID, String pid, double orderedQuantity) {
		
		OrderDetail orderDetail = orderManager.addSmartphoneOrderDetail(odid, orderID, pid, orderedQuantity);
		
		SmartphoneOrderDetailRepresentation smartphoneOrderDetailRepresentation = new SmartphoneOrderDetailRepresentation();
  		
		smartphoneOrderDetailRepresentation.setOrderDetailID(orderDetail.getOrderDetailID());
		smartphoneOrderDetailRepresentation.setSmartphoneProductID(orderDetail.getSmartphoneProductID());
		smartphoneOrderDetailRepresentation.setOrderID(orderDetail.getOrderID());
		smartphoneOrderDetailRepresentation.setOrderedQuantity(orderDetail.getOrderedQuantity());
        
		return smartphoneOrderDetailRepresentation;
	}

	public String updateSmartphoneOrderDetail(String odid, String orderID, String pid, double orderedQuantity) {
		orderManager.updateSmartphoneOrderDetail(odid, orderID, pid, orderedQuantity);
		return "OK";
	}

	public String deleteOrderDetail(String id) {
		orderManager.deleteOrderDetail(id);
		return "OK";
	}
}
