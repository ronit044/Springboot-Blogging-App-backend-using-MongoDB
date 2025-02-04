package com.bloggingApp.bloggingApplication.repositories;

import com.bloggingApp.bloggingApplication.entities.Blog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepo extends MongoRepository<Blog, ObjectId> {
}
