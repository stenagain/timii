/**
 * 
 */
package org.cloud.timii.review;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cloud.timii.Res;

/**
 * @author sten
 *
 */
@Path("/review")
public class ReviewEndpoint {
	private ReviewService service = new DefaultReviewService();
	private static final Logger LOG = Logger.getLogger(ReviewEndpoint.class.getName());

	/**
	 * 
	 */
	public ReviewEndpoint() {
		LOG.info("ReviewEndpoint Created!!!!!!");

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReviews() {
		return Response.status(Response.Status.OK).entity(service.getReviews()).build();
	}

	@GET
	@Path("{id}")
	public Response getReview(@PathParam("id") String id) {

		return Response.status(Response.Status.OK).entity(service.getReviews()).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createReview(Review review) {
		LOG.info("Review: " + review);
		Res<Review> res = service.createReview(review);
		return Response.status(Response.Status.OK).entity(res).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateReview(Review review) {
		LOG.info("Review: " + review);
		Res<Review> res = service.updateReview(review);
		return Response.status(Response.Status.OK).entity(res).build();
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteReview(@PathParam("id") String id) {
		LOG.info("Delete Review: " + id);
		Res<Review> res = service.deleteReview(id);
		return Response.status(Response.Status.OK).entity(res).build();
	}

}
