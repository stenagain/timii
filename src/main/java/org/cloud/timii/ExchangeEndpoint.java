/**
 * 
 */
package org.cloud.timii;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sten
 *
 */
@Path("/exchange")
public class ExchangeEndpoint {

	ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = Logger.getLogger(ExchangeEndpoint.class
			.getName());

	@GET
	public Response getStatus() {
		return Response.status(Response.Status.OK).entity("Welcome to the Exchange").build();
	}

}
