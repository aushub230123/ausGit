package com.DSSystem.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DSSystem.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer>{
	

	/*
	 * The @Query annotation can be used to create queries by using the JPA query language 
	 * and to bind these queries directly to the methods of your repository interface. 
	 * When the query method is called, Spring Data JPA will execute the query specified by the @Query annotation
	 */
	@Query(value = "select * from movies where not exists(select movie_id from reviews WHERE reviews.movie_id = movies.movie_id)",
            nativeQuery = true)
    List<Movie> queryNoReviewMovies();
	
	List<Movie> findByActorId(Integer actorId);
	
	//
	 @Query (value =("SELECT * FROM movies WHERE release_year < DATE_SUB(NOW(),INTERVAL 1 YEAR) and movie_id = :movieId"),
     nativeQuery = true)
		Movie movieOlderThanOneYear(@Param("movieId") Integer movieId);
	 @Query(value = ("DELETE movies,reviews FROM movies INNER JOIN reviews ON reviews.movie_id = movies.movie_id WHERE movies.movie_id = :movieId"),
			 nativeQuery = true)
	Movie deleteMovieAndAssociatedReviews(@Param("movieId") Integer movieId);
}
