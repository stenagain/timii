/**
 * 
 */
package org.cloud.timii.review;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sten
 *
 */
public class Reviews {
	private List<Review> reviews = new ArrayList<Review>();

	/**
	 * @return the reviews
	 */
	public List<Review> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
