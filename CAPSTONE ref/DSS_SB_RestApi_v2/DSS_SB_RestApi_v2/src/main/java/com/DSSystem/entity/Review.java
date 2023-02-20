package com.DSSystem.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Tulip
 *This class holds the model for Movie review
 */
//Model mapped to a row in the table. [ORM]
@Entity
@Table(name="REVIEWS")
public class Review {
	public Review(Integer reviewId, String datePosted, String description, Integer rating, Integer movieId) {
		super();
		this.reviewId = reviewId;
		this.datePosted = datePosted;
		this.description = description;
		this.rating = rating;
		this.movieId = movieId;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public String getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Review() {};
	

	//	Uniqueness
	@Id
//	Auto generate Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="REVIEW_ID")
	private Integer reviewId;
	
	@Column(name="DATE_POSTED", nullable = false)
	private String datePosted;
	
	@Column(name="DESCRIPTION", nullable = false)
	private String description;
	
	@Column(name="RATING", nullable = false)
	private Integer rating;
	
	@Column(name="MOVIE_ID", nullable = false)
	private Integer movieId;
	
	
	
}