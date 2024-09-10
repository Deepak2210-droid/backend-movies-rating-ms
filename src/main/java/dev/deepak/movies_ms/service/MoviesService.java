package dev.deepak.movies_ms.service;

import dev.deepak.movies_ms.pojo.Movie;
import dev.deepak.movies_ms.pojo.MovieDTO;
import dev.deepak.movies_ms.repo.MoviesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService {

	@Autowired
	private MoviesRepository movieRepository;

	public List<MovieDTO> allMovies() {

		List<Movie> moviesList = movieRepository.findAll();

		return moviesList.stream().map(movie -> convertToDTO(movie)).collect(Collectors.toList());
	}

	public MovieDTO singleMovies(String id) {

		Movie movie = movieRepository.findByImdbId(id).orElse(null);
		return convertToDTO(movie);
	}

	private MovieDTO convertToDTO(Movie movie) {
		MovieDTO movieDTO = new MovieDTO(movie.getImdbId(), movie.getTitle(), movie.getReleaseDate(),
				movie.getTrailerLink(), movie.getPoster(), movie.getGenres(), movie.getBackdrops(),
				movie.getReviewIds());
		return movieDTO;
	}

	private MovieDTO convertToDocumentObject(MovieDTO movieDTO) {
		Movie movie = new Movie(movieDTO.getImdbId(), movieDTO.getTitle(), movieDTO.getReleaseDate(),
				movieDTO.getTrailerLink(), movieDTO.getPoster(), movieDTO.getGenres(), movieDTO.getBackdrops(),
				movieDTO.getReviewIds());
		return movieDTO;
	}
}
