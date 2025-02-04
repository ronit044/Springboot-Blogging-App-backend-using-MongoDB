package com.bloggingApp.bloggingApplication.controllers;

import com.bloggingApp.bloggingApplication.entities.Blog;
import com.bloggingApp.bloggingApplication.entities.User;
import com.bloggingApp.bloggingApplication.services.BlogUserServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("blog")
public class BlogUserController {
    @Autowired
    private BlogUserServices service;
    @PostMapping("{id}")
    public ResponseEntity<?> addPost(@PathVariable ObjectId id, @RequestBody Blog blog) {
        try{
            User res=service.addBlog(id,blog);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
