/**
 * 
 */
package org.cloud.timii.exchange;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sten
 *
 */
@Path("/exchange")
public class ExchangeEndpoint {

	private static final ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = Logger.getLogger(ExchangeEndpoint.class.getName());

	private Exchange exchange = new ExchangeService();

	@GET
	public Response listOffers() {
		return Response.status(Response.Status.OK).entity(exchange.listOffers()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("offer")
	public Response offerProduct(Message offer) {
		return Response.status(Response.Status.OK).entity(exchange.offerProduct(offer)).build();
	}

}
