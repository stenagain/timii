/**
 * 
 */
package org.cloud.timii.review;

/**
 * @author sten
 *
 */
public class Review {
	public enum Rating {
		ONE, TWO, THREE, FOUR, FIVE;
	}

	private String ID;
	private String reviewerID;
	private String productID;
	private String review;
	private Rating rating = Rating.FIVE;

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the userID
	 */
	public String getReviewerID() {
		return reviewerID;
	}

	/**
	 * @param reviewerID
	 *            the userID to set
	 */
	public void setReviewerID(String reviewerID) {
		this.reviewerID = reviewerID;
	}

	/**
	 * @return the productID
	 */
	public String getProductID() {
		return productID;
	}

	/**
	 * @param productID
	 *            the productID to set
	 */
	public void setProductID(String productID) {
		this.productID = productID;
	}

	/**
	 * @return the review
	 */
	public String getReview() {
		return review;
	}

	/**
	 * @param review
	 *            the review to set
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * @return the rating
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}

}
