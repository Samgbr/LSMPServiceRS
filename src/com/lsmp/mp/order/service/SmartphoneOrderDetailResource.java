package com.lsmp.mp.order.service;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lsmp.mp.order.service.representation.SmartphoneOrderDetailRepresentation;
import com.lsmp.mp.order.service.representation.SmartphoneOrderDetailRequest;
import com.lsmp.mp.order.service.workflow.SmartphoneOrderDetailActivity;

@Path("/smartphoneorderdetailservice/")
public class SmartphoneOrderDetailResource implements SmartphoneOrderDetailService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/smartphoneorderdetails")
	public Set<SmartphoneOrderDetailRepresentation> getSmartphoneOrderDetails() {
		System.out.println("GET METHOD Request for all Smartphone Order Details .............");
		SmartphoneOrderDetailActivity smartphoneOrderDetailActivity = new SmartphoneOrderDetailActivity();
		return smartphoneOrderDetailActivity.getAllSmartphoneOrderDetails();
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/smartphoneorderdetail/{oderDetailId}")
	public SmartphoneOrderDetailRepresentation getSmartphoneOrderDetail(@PathParam("oderDetailId") String id) {
		System.out.println("GET METHOD Request from Client with Smartphone Order Detail Request String ............." + id);
		SmartphoneOrderDetailActivity smartphoneOrderDetailActivity = new SmartphoneOrderDetailActivity();
		return smartphoneOrderDetailActivity.getSmartphoneOrderDetail(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphoneorderdetail")
	public SmartphoneOrderDetailRepresentation createSmartphoneOrderDetail(SmartphoneOrderDetailRequest smartphoneOrderDetailRequest) {
		System.out.println("POST METHOD Smartphone Order Detail Request from Client with ............." );		
		SmartphoneOrderDetailActivity smartphoneOrderDetailActivity = new SmartphoneOrderDetailActivity();
		return smartphoneOrderDetailActivity.addSmartphoneOrderDetail(smartphoneOrderDetailRequest.getOrderDetailID(), smartphoneOrderDetailRequest.getOrderID()
				, smartphoneOrderDetailRequest.getSmartphoneProductID(), smartphoneOrderDetailRequest.getOrderedQuantity());
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphoneorderdetail")
	public Response updateSmartphoneOrderDetail(SmartphoneOrderDetailRequest smartphoneOrderDetailRequest) {
		System.out.println("PUT METHOD Smartphone Order Detail Request from Client with ............." );		
		SmartphoneOrderDetailActivity smartphoneOrderDetailActivity = new SmartphoneOrderDetailActivity();
		String res = smartphoneOrderDetailActivity.updateSmartphoneOrderDetail(smartphoneOrderDetailRequest.getOrderDetailID(), smartphoneOrderDetailRequest.getOrderID()
				, smartphoneOrderDetailRequest.getSmartphoneProductID(), smartphoneOrderDetailRequest.getOrderedQuantity());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/smartphoneorderdetail/{oderDetailId}")
	public Response deleteSmartphoneOrderDetail(@PathParam("oderDetailId") String id) {
		System.out.println("Delete METHOD Request from Client with Smartphone Order Detail Request String ............." + id);
		SmartphoneOrderDetailActivity smartphoneOrderDetailActivity = new SmartphoneOrderDetailActivity();
		String res = smartphoneOrderDetailActivity.deleteOrderDetail(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}



}
