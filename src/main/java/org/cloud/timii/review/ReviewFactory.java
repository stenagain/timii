/**
 * 
 */
package org.cloud.timii.review;

import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sten
 *
 */
public class ReviewFactory {
	public Review create() {
		Review r = new Review();
		r.setID(UUID.randomUUID().toString());
		r.setRating(Review.Rating.ONE);
		r.setReview("This procut was horrible!!!");
		r.setProductID("3");
		r.setUserID("user:23444");
		return r;
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ReviewFactory factory = new ReviewFactory();
		Review r = factory.create();
		String content = mapper.writeValueAsString(r);
		System.out.println(content);
		
	}
}
