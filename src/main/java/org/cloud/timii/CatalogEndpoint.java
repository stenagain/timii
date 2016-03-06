/**
 * 
 */
package org.cloud.timii;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.cloud.timii.model.Product;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sten
 *
 */
@Path("/catalog")
public class CatalogEndpoint {
	private static final Logger LOG = Logger.getLogger(ExchangeEndpoint.class
			.getName());

	

	
	@GET
	public Response getCatalog() {
		return Response.status(Response.Status.OK).entity("Welcome to the Catalog").build();
	}
	
	@POST
	@Consumes("application/json")
	public Response addProduct(Product product) {
		System.out.println(product);
		
		
		return Response.status(Response.Status.OK).entity("ADDED").build();
	}

}
