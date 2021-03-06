/**
 * 
 */
package org.cloud.timii.exchange;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cloud.timii.Res;
import org.cloud.timii.exchange.ExchangeEndpoint;

/**
 * @author sten, misha
 * 
 */
@Path("/product")
public class CommodityEndpoint{

	private CommodityService service = new DefaultCommodityService(); 
	private static final Logger LOG = Logger.getLogger(ExchangeEndpoint.class.getName());

	
	public CommodityEndpoint() {
		LOG.info("ProductEndpoint Created!!!!!!");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReviews() {
		return Response.status(Response.Status.OK).entity(service.getProducts()).build();
	}
	
		
	/* (non-Javadoc)
	 * @see org.cloud.timii.product.ProductService#getProducts(java.lang.String)
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{description}")
	public Response getProducts(@QueryParam("description") String descStr) {
		return Response.status(Response.Status.OK).entity(service.getProducts(descStr)).build();	
	}

	/* (non-Javadoc)
	 * @see org.cloud.timii.product.ProductService#getProductByID(java.lang.String)
	 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getProductByID(@PathParam("id") String id) {
		return Response.status(Response.Status.OK).entity(service.getProductByID(id)).build();		
	}

		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProduct(Commodity product) {
		System.out.println(product);
		Res<Commodity> p  = service.createProduct(product);
		return Response.status(Response.Status.OK).entity(p).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProduct(Commodity p) {
		LOG.info("Calling Update Product: " + p);
		Res<Commodity> prod = service.updateProduct(p);
		return Response.status(Response.Status.OK).entity(prod).build();
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduct(@PathParam("id") String id) {
		LOG.info("Delete Product: " + id);
		Res<Commodity> p = service.deleteProduct(id);
		return Response.status(Response.Status.OK).entity(p).build();
	}


}