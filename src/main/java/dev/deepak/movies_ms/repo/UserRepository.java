package dev.deepak.movies_ms.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.deepak.movies_ms.pojo.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{

}
