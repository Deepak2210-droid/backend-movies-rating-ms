package dev.deepak.movies_ms.repo;

import dev.deepak.movies_ms.pojo.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoviesRepository extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> findByImdbId(String imdbId);
}
