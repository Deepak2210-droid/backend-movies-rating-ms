package dev.deepak.movies_ms.controller;

import dev.deepak.movies_ms.pojo.Movie;
import dev.deepak.movies_ms.pojo.MovieDTO;
import dev.deepak.movies_ms.repo.MoviesRepository;
import dev.deepak.movies_ms.service.MoviesService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {
	private final static Logger log = LoggerFactory.getLogger(MoviesController.class);                                                                                     

	@Autowired
	private MoviesService movieService;

	@GetMapping
	public ResponseEntity<List<MovieDTO>> getAllMovies() {
		List<MovieDTO> allMovies = movieService.allMovies();

		return new ResponseEntity<List<MovieDTO>>(allMovies, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> getSingleMovie(@PathVariable String id) {

		return new ResponseEntity<MovieDTO>(movieService.singleMovies(id), HttpStatus.OK);
	}

}
