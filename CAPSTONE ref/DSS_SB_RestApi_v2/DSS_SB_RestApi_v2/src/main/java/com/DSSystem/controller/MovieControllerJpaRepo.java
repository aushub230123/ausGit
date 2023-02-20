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

import com.DSSystem.entity.Genre;
import com.DSSystem.entity.Movie;
import com.DSSystem.repository.GenreRepository;
import com.DSSystem.repository.MovieRepository;

// http://localhost:8080/api/v1/movies

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieControllerJpaRepo {
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private  GenreRepository genreRepository;
	
	@GetMapping("/movies")
	public List<Movie> getMovieList() {
		List<Movie> movieList = null;
			movieList = movieRepository.findAll();
			return movieList;
	}
	
	@GetMapping("/movies/noReviews")
	public List<Movie> getNoReviewMovieList() {
		List<Movie> movieList = movieRepository.queryNoReviewMovies();
		return movieList;
	}
	
	
	@GetMapping("/genres")
	public List<Genre> getGenreList() {
		List<Genre> genreList = genreRepository.findAll();
		return genreList;
	}

	@GetMapping("/movies/{id}")
	public Movie getMovieById(@PathVariable(value = "id") Integer id) {
		Movie existingMovie = movieRepository.findById(id).get();
		return existingMovie;
	}
	
	@GetMapping("/movies/checkForOneYearOld/{id}")
	public Boolean movieOlderThanOneYear(@PathVariable(value = "id") Integer id) {
		Movie existingMovie = movieRepository.movieOlderThanOneYear(id);
		if(existingMovie != null)
			return true;
		else
			return false;
		
	}
	
	@GetMapping("/movies/withActor/{id}")
	public List<Movie> getMoviesByActorId(@PathVariable(value = "id") Integer id) {
		List<Movie> existingMovie = movieRepository.findByActorId(id);
		return existingMovie;
	}
	

	@PostMapping("/movies")
	public Movie createMovie(@RequestBody Movie movie) {
		
		Movie savedMovie = movieRepository.save(movie);
		return savedMovie;
	}

	@PutMapping("/movies/{id}")
	public Movie updateMovie(@PathVariable(value = "id") Integer id, @RequestBody Movie movie) {
		// fetch the movie
		Movie existingMovie = movieRepository.findById(id).get();
		existingMovie.setMovieId(movie.getMovieId());
		existingMovie.setMovieName(movie.getMovieName());
		existingMovie.setActorId(movie.getActorId());
		existingMovie.setDuration(movie.getDuration());
		existingMovie.setGenreId(movie.getGenreId());
		existingMovie.setOverview(movie.getOverview());
		existingMovie.setMovieUrl(movie.getMovieUrl());
		
		existingMovie.setActorId(movie.getActorId());
		existingMovie.setCost(movie.getCost());
		existingMovie.setReleaseYear(movie.getReleaseYear());

		Movie savedMovie = movieRepository.save(movie);
		return savedMovie;
	}

	@DeleteMapping("/movies/{id}")
	public Movie deleteMovieById(@PathVariable(value = "id") Integer id) {
		Movie deletedMovie = movieRepository.findById(id).get();
		movieRepository.delete(deletedMovie);
		return deletedMovie;
	}

//	@DeleteMapping("/movies/{id}")
//	public Map<String,Boolean> deleteMovieById(@PathVariable(value="id") Integer id) {
//		Movie existingMovie = movieRepository.findById(id).get();
//	    movieRepository.delete(existingMovie);
//	    Map<String, Boolean> response = new HashMap<>();
//	    response.put("deleted", Boolean.TRUE);
//		return response;
//	}

}
