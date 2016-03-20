/**
 * 
 */
package org.cloud.timii.review;

import org.cloud.timii.Res;

/**
 * @author sten
 *
 */
public interface ReviewService {

	public Res<Review> createReview(Review review);

	public Res<Review> updateReview(Review review);

	public Res<Review> deleteReview(String ID);

	public Res<Reviews> getReviews(String... ID);

	public Res<Reviews> getReviews();
}
