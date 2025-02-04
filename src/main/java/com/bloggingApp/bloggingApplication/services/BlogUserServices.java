package com.bloggingApp.bloggingApplication.services;

import com.bloggingApp.bloggingApplication.entities.Blog;
import com.bloggingApp.bloggingApplication.entities.User;
import com.bloggingApp.bloggingApplication.repositories.BlogRepo;
import com.bloggingApp.bloggingApplication.repositories.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BlogUserServices {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BlogRepo blogRepo;
    @Transactional
    public User addBlog(ObjectId userID, Blog blog) {
        Optional<User> optionalUser = userRepo.findById(userID);
            blogRepo.save(blog);
            User user = optionalUser.get();
            user.getUserBlogs().add(blog);
            return userRepo.save(user);
    }
}
