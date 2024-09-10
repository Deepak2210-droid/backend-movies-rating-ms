package dev.deepak.movies_ms.service;

import dev.deepak.movies_ms.exception.MovieMsException;
import dev.deepak.movies_ms.pojo.CommonResponse;
import dev.deepak.movies_ms.pojo.Movie;
import dev.deepak.movies_ms.pojo.Review;
import dev.deepak.movies_ms.pojo.ReviewDTO;
import dev.deepak.movies_ms.repo.MoviesRepository;
import dev.deepak.movies_ms.repo.ReviewRespository;

import java.util.List;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

	@Autowired
	private ReviewRespository reviewRespository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public ReviewDTO createReview(String reviewBody, String imdbId) {
		Review review = reviewRespository.insert(new Review(reviewBody, UUID.randomUUID().toString().substring(0, 10)));

		Query query = new Query(Criteria.where("imdbId").is(imdbId));

		// List<Movie> movies= mongoTemplate.find(query, Movie.class);
		mongoTemplate.updateFirst(query, new Update().push("reviewIds", review), Movie.class);

		return convertToDTO(review);
	}

	public CommonResponse updateReview(String reviewBody, String reviewId) {

		try {
			Query query = new Query(Criteria.where("reviewId").is(reviewId));
			mongoTemplate.updateFirst(query, new Update().set("body", reviewBody), Review.class);

			return new CommonResponse("Success", reviewId + "updated");
		} catch (Exception e) {
			throw new MovieMsException(reviewId + "failed to update");
		}

	}

	public CommonResponse deleteReview(String reviewId) {
		try {
			Query query = new Query(Criteria.where("reviewId").is(reviewId));
			mongoTemplate.remove(query, Review.class);

			return new CommonResponse("Success", reviewId + "deleted");
		} catch (Exception e) {
			throw new MovieMsException(reviewId + "failed to delete");
		}
	}

	private ReviewDTO convertToDTO(Review review) {
		ReviewDTO reviewDTO = new ReviewDTO(review.getBody(), review.getReviewId());
		return reviewDTO;
	}
}
