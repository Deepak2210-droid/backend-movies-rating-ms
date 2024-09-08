package dev.deepak.movies_ms;

import dev.deepak.movies_ms.pojo.Movie;
import dev.deepak.movies_ms.repo.MoviesRepository;
import dev.deepak.movies_ms.service.MoviesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    @Autowired
    private MoviesService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){

        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getSingleMovie(@PathVariable String id){

        return new ResponseEntity<Movie>(movieService.singleMovies(id),HttpStatus.OK);
    }

}
