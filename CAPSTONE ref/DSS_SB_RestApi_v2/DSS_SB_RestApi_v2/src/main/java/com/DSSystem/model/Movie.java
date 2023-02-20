package com.DSSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tulip
 *This class holds the entity named Movie
 */

//Model mapped to a row in the table. [ORM]



public class Movie {

	
	private Integer movieId;
	
	
	private String movieName;
	
	
	private Integer movieActorId;
	
	
		private Integer movieDuration;
	
	
	private Integer movieGerne;
	
	
	private String movieOverview;

	
	private String movieUrl;
	
	
	private Integer movieReview;
	
	
	private Integer movieCost;

	
	private Integer movieReleaseYear;
		
}