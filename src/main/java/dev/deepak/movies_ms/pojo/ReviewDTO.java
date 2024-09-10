package dev.deepak.movies_ms.pojo;

public class ReviewDTO {
	private String body;

	private String reviewId;

	public ReviewDTO(String body, String reviewId) {
		super();
		this.body = body;
		this.reviewId = reviewId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getReviewId() {
		return reviewId;
	}

	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
}
