package dev.deepak.movies_ms.controller;

import dev.deepak.movies_ms.pojo.CommonResponse;
import dev.deepak.movies_ms.pojo.Review;
import dev.deepak.movies_ms.pojo.ReviewDTO;
import dev.deepak.movies_ms.service.ReviewService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
	
	private final static Logger log = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@RequestBody Map<String, String> payload){
    	
    	ReviewDTO review = reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId"));
    	log.info("CreateReview response {}", review);
        return new ResponseEntity<ReviewDTO>(review, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CommonResponse> updateReview(@RequestBody Map<String, String> payload){

    	CommonResponse updateReviewResponse = reviewService.updateReview(payload.get("reviewBody"),payload.get("reviewId"));
        return new ResponseEntity<CommonResponse>(updateReviewResponse, HttpStatus.OK);

    }
    
    @DeleteMapping
    public ResponseEntity<CommonResponse> deleteReview(@RequestBody Map<String, String> payload){

    	CommonResponse deleteReviewResponse = reviewService.deleteReview(payload.get("reviewId"));
        return new ResponseEntity<CommonResponse>(deleteReviewResponse, HttpStatus.OK);

    }
}
