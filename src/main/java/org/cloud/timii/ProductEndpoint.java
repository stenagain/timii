/**
 * 
 */
package org.cloud.timii;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.cloud.timii.catalog.Product;
import org.cloud.timii.catalog.Products;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sten
 *
 */
@Path("/product")
public class ProductEndpoint {

	private static final Logger LOG = Logger.getLogger(ExchangeEndpoint.class
			.getName());

	/**
	 * 
	 */
	public ProductEndpoint() {
		System.out.println("Created!!!!!!!!"); // TODO Auto-generated
												// constructor stub
	}

	@GET
	public Response getProducts(@QueryParam("description") String descStr) {

		Products prods;
		if (descStr != null) {
			prods = DataContext.getInstance().getProducts();
			List<Product> ll = new ArrayList<Product>();
			for (Product p : prods.getProducts().values()) {
				if (p.getDescription().contains(descStr)) {
					ll.add(p);
				}
			}

			if (ll.size() > 0) {
				try {
					return Response.status(Response.Status.OK)
							.entity(new ObjectMapper().writeValueAsString(ll))
							.build();
				} catch (JsonProcessingException e) {
					return Response.status(Response.Status.BAD_REQUEST).build();
				}
			} else {
				Response.status(Response.Status.NOT_FOUND)
						.entity("Product Not Found").build();

			}

		}

		try {
			return Response
					.status(Response.Status.OK)
					.entity(new ObjectMapper().writeValueAsString(DataContext
							.getInstance().getProducts())).build();
		} catch (JsonProcessingException e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getProductByID(@PathParam("id") String id) {

		Product product = DataContext.getInstance().getProducts().getProducts()
				.get(id);
		if (product != null) {
			try {
				return Response.status(Response.Status.OK)
						.entity(new ObjectMapper().writeValueAsString(product))
						.build();
			} catch (JsonProcessingException e) {
				return Response
						.status(Response.Status.BAD_REQUEST)
						.entity("Great Caesar's Localhost!! Something Bad Happened!!")
						.build();
			}

		}

		return Response.status(Response.Status.NOT_FOUND)
				.entity("Product Not Found").build();

	}

	@POST
	@Consumes("application/json")
	public Response addProduct(Products product) {
		System.out.println(product);

		return Response.status(Response.Status.OK).entity("ADDED").build();
	}

}
