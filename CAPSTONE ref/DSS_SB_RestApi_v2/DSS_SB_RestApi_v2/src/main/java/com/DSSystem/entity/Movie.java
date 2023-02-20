package com.DSSystem.entity;

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


//Model mapped to a row in the table. [ORM]
@Entity
// MOVIE > MOVIES
@Table(name="MOVIES")
public class Movie {
	public Movie(Integer movieId, String movieName, Integer actorId, String duration, Integer genreId, String overview,
			String movieUrl,  Integer cost, String releaseYear) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.actorId = actorId;
		this.duration = duration;
		this.genreId = genreId;
		this.overview = overview;
		this.movieUrl = movieUrl;
		
		this.cost = cost;
		this.releaseYear = releaseYear;
	}
	public Movie() {};
	//	Uniqueness
	@Id
//	Auto generate Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MOVIE_ID")
	private Integer movieId;
	
	@Column(name="MOVIE_NAME", nullable = false)
	private String movieName;
	
	@Column(name="ACTOR_ID", nullable = false)
	private Integer actorId;
	
	
	@Column(name="DURATION", nullable = false)
	private String duration;
	
	@Column(name="GENRE_ID", nullable = false)
	private Integer genreId;
	
	@Column(name="OVERVIEW", nullable = false)
	private String overview;

	@Column(name="MOVIE_URL", nullable = false)
	private String movieUrl;
	

	
	@Column(name="COST", nullable = false)
	private Integer cost;

	@Column(name="ReleaseYear", nullable = false)
	private String releaseYear;

	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getActorId() {
		return actorId;
	}
	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genre) {
		this.genreId = genre;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getMovieUrl() {
		return movieUrl;
	}
	public void setMovieUrl(String movieUrl) {
		this.movieUrl = movieUrl;
	}

	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
		
}