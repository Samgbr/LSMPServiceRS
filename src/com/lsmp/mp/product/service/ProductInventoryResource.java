package com.lsmp.mp.product.service;

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

import com.lsmp.mp.product.service.representation.ProductInventoryRepresentation;
import com.lsmp.mp.product.service.representation.ProductInventoryRequest;
import com.lsmp.mp.product.service.workflow.ProductInventoryActivity;

@Path("/productinventoryservice/")
public class ProductInventoryResource implements ProductInventoryService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/productinventory/{productId}")
	public ProductInventoryRepresentation getProductQtyOnHand(@PathParam("productId") String id) {
		System.out.println("GET METHOD Request from Client with Product Inventory Request String ............." + id);
		ProductInventoryActivity productInventoryActivity=new ProductInventoryActivity();
		return productInventoryActivity.getProductQtyOnHand(id);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/productinventory")
	public ProductInventoryRepresentation createProductInventory(ProductInventoryRequest productInventoryRequest) {
		System.out.println("POST METHOD Product Inventory Request from Client with ............." );		
		ProductInventoryActivity productInventoryActivity=new ProductInventoryActivity();
		String pid = (String)productInventoryRequest.getQtyOnHandMap().keySet().toArray()[0];
		return productInventoryActivity.createProductInventory(productInventoryRequest.getInventoryID(), pid, productInventoryRequest.getQtyOnHandMap().get(pid));
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/productinventory")
	public Response updateProductInventory(ProductInventoryRequest productInventoryRequest) {
		System.out.println("PUT METHOD Product Inventory Request from Client with ............." );		
		ProductInventoryActivity productInventoryActivity=new ProductInventoryActivity();
		String pid = (String)productInventoryRequest.getQtyOnHandMap().keySet().toArray()[0];
		String res = productInventoryActivity.updateProductInventory(pid, productInventoryRequest.getQtyOnHandMap().get(pid));
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/productinventory/{productId}")
	public Response deleteProductInventory(@PathParam("productId") String id) {
		System.out.println("Delete METHOD Request from Client with Product Inventory Request String ............." + id);
		ProductInventoryActivity productInventoryActivity=new ProductInventoryActivity();
		String res = productInventoryActivity.deleteProductInventory(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

	
	
}
