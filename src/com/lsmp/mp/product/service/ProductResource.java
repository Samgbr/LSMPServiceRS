package com.lsmp.mp.product.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.lsmp.mp.product.service.representation.ProductRepresentation;
import com.lsmp.mp.product.service.workflow.ProductActivity;

@Path("/productservice/")
public class ProductResource implements ProductService {
	//GET,CREATE,DELETE AND UPDATE A PRODUCT
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{productId}")
	public ProductRepresentation getProduct(@PathParam("productId") String id) {
		System.out.println("GET METHOD Request from Client with productRequest String ............." + id);
		ProductActivity productActivity=new ProductActivity();
		return productActivity.getProduct(id);
	}

}
