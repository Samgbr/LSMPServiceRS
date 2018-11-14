package com.lsmp.mp.order.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.lsmp.mp.link.AbstractRepresentation;

@XmlRootElement(name = "paymentRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PaymentRepresentation extends AbstractRepresentation{
	
	private String orderID;
	private double amount;
	private String billID;
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getBillID() {
		return billID;
	}
	public void setBillID(String billID) {
		this.billID = billID;
	}
	
}
