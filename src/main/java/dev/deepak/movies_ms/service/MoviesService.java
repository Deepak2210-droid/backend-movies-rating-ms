package dev.deepak.movies_ms.service;

import dev.deepak.movies_ms.pojo.Movie;
import dev.deepak.movies_ms.repo.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository movieRepository;

    public List<Movie> allMovies(){

        return movieRepository.findAll();
    }
}
