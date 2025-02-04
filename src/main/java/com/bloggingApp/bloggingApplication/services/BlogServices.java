package com.bloggingApp.bloggingApplication.services;

import com.bloggingApp.bloggingApplication.entities.Blog;
import com.bloggingApp.bloggingApplication.repositories.BlogRepo;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServices {
    private BlogRepo repository;
    public Blog editBlog(ObjectId blogID, Blog newBlog) {
        try{
            Optional<Blog> optionalBlog = repository.findById(blogID);
            if(optionalBlog.isPresent()){
                Blog oldBlog = optionalBlog.get();
                oldBlog.setTitle(newBlog.getTitle()!=null?newBlog.getTitle():oldBlog.getTitle());
                oldBlog.setDescription(newBlog.getDescription()!=null?newBlog.getDescription():oldBlog.getDescription());
                return repository.save(oldBlog);
            }
            else{
                throw new Exception("Invalid blog ID!!");
            }
        }catch(Exception e){
            throw new RuntimeException("Something went wrong!!");
        }
    }
}
