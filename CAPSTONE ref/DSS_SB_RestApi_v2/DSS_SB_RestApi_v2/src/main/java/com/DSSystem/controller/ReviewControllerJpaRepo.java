package com.DSSystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DSSystem.entity.Review;
import com.DSSystem.repository.ReviewRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewControllerJpaRepo {
	@Autowired
	private ReviewRepository reviewRepository;
	
	@GetMapping("/reviews")
	public List<Review> getReviewList() {
		List<Review> reviewList = reviewRepository.findAll();
		return reviewList;
	}
	
	@GetMapping("/reviews/{id}")
	public Review getReviewById(@PathVariable(value="id") Integer id) {
		Review existingReview = reviewRepository.findById(id).get();
		return existingReview;
	}

	@PostMapping("/reviews")
	public Review createReview(@RequestBody Review review) {
		Review savedReview = reviewRepository.save(review);
		return savedReview;
	}
	
	@PutMapping("/reviews/{id}")
	public Review updateReview(@PathVariable(value="id") Integer id, @RequestBody Review review) {
		// fetch the review
		Review existingReview = reviewRepository.findById(id).get();
		existingReview.setReviewId(review.getReviewId());
		existingReview.setDatePosted(review.getDatePosted());
		existingReview.setDescription(review.getDescription());
		existingReview.setRating(review.getRating());
		existingReview.setMovieId(review.getMovieId());
		
		
		Review savedReview = reviewRepository.save(review);
		return savedReview;
	}
	@DeleteMapping("/reviews/{id}")
	public Review deleteReviewById(@PathVariable(value="id") Integer id) {
		Review existingReview = reviewRepository.findById(id).get();
	    reviewRepository.delete(existingReview);
		return existingReview;
	}
	
//	@DeleteMapping("/reviews/{id}")
//	public Map<String,Boolean> deleteReviewById(@PathVariable(value="id") Integer id) {
//		Review existingReview = reviewRepository.findById(id).get();
//	    reviewRepository.delete(existingReview);
//	    Map<String, Boolean> response = new HashMap<>();
//	    response.put("deleted", Boolean.TRUE);
//		return response;
//	}
}
