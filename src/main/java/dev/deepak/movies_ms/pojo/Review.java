package dev.deepak.movies_ms.pojo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "Review")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {

	public Review(String body, String reviewId) {
		super();
		this.body = body;
		this.reviewId = reviewId;
	}

	@Id
	private ObjectId id;

	private String body;

	private String reviewId;

	

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
