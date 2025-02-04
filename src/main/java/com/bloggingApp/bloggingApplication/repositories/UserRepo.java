package com.bloggingApp.bloggingApplication.repositories;

import com.bloggingApp.bloggingApplication.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, ObjectId> {
}
