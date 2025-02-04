package com.bloggingApp.bloggingApplication.controllers;

import com.bloggingApp.bloggingApplication.entities.User;
import com.bloggingApp.bloggingApplication.services.UserServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServices userService;
    @GetMapping("allUsers")
    public ResponseEntity<?> getAllUsers() {
        try {
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            User foundUser = userService.findById(objectId).orElse(null);
            if (foundUser != null) {
                return new ResponseEntity<>(foundUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try{
            User createdUser=userService.registerUser(user);
            return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody User user) {
        try{
            ObjectId objectId = new ObjectId(id);
            User updatedUser=userService.updateUser(user,objectId);
            return new ResponseEntity<>(updatedUser,HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
