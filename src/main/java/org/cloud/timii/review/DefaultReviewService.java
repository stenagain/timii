/**
 * 
 */
package org.cloud.timii.review;

import java.util.HashMap;
import java.util.Map;

import org.cloud.timii.Res;

/**
 * @author sten
 *
 */
public class DefaultReviewService implements ReviewService {

	private Map<String, Review> reviewMap = new HashMap<String, Review>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cloud.timii.review.ReviewService#createReview(org.cloud.timii.review
	 * .Review)
	 */
	public Res<Review> createReview(Review review) {

		if (checkReview(review)) {
			reviewMap.put(review.getID(), review);
			return new Res<Review>(Res.Type.CREATED, "review created", review);
		}

		return new Res<Review>(Res.Type.BAD_REQUEST, "invalid id", null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cloud.timii.review.ReviewService#updateReview(org.cloud.timii.review
	 * .Review)
	 */
	public Res<Review> updateReview(Review review) {
		if (checkReview(review)) {
			if (reviewMap.containsKey(review.getID())) {
				reviewMap.put(review.getID(), review);
				// reviewMap.put(review.getProductID(), review);
				return new Res<Review>(Res.Type.OK, "review updated", review);
			}
		}
		return new Res<Review>(Res.Type.BAD_REQUEST, "invalid id", null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cloud.timii.review.ReviewService#deleteReview()
	 */
	public Res<Review> deleteReview(String ID) {
		if (null != ID) {
			if (reviewMap.containsKey(ID)) {
				// reviewMap.remove(review.getID());
				Review review = reviewMap.remove(ID);

				return new Res<Review>(Res.Type.OK, "review deleted", review);
			}
		}
		return new Res<Review>(Res.Type.BAD_REQUEST, "invalid id", null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cloud.timii.review.ReviewService#getReview(java.lang.String)
	 */
	public Res<Reviews> getReviews(String... ID) {
		Reviews reviews = new Reviews();
		for (String string : ID) {
			if (reviewMap.containsKey(string)) {
				reviews.getReviews().add(reviewMap.get(string));
			}
		}
		return new Res<Reviews>(Res.Type.NOT_FOUND, "review not found", reviews);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cloud.timii.review.ReviewService#getReviews()
	 */
	public Res<Reviews> getReviews() {
		Reviews revs = new Reviews();
		revs.getReviews().addAll(reviewMap.values());
		return new Res<Reviews>(Res.Type.OK, "found reviews", revs);
	}

	/**
	 * Simple check of a Review
	 * 
	 * @param review
	 * @return
	 */
	private boolean checkReview(Review review) {
		if (null == review || null == review.getID()
				|| null == review.getProductID() || null == review.getReviewerID()) {
			return false;
		}
		return true;
	}
}
