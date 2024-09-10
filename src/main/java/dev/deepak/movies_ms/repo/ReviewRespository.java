package dev.deepak.movies_ms.repo;

import dev.deepak.movies_ms.pojo.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRespository extends MongoRepository<Review, ObjectId> {
}
