package com.DSSystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;

/**
 * @author Tulip
 *This class holds the model for Movie review
 */
public class Review {

	private Integer reviewId;
	private Date reviewDatePosted;
	private String reviewDescription;
	private Integer reviewRating;
	private Integer movieId;
	
	
	
}