package com.bloggingApp.bloggingApplication.services;

import com.bloggingApp.bloggingApplication.entities.User;
import com.bloggingApp.bloggingApplication.repositories.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepo repository;
    public ArrayList<User> findAll() {
        return (ArrayList<User>) repository.findAll();
    }
    public Optional<User> findById(ObjectId id) {
        return repository.findById(id);
    }
    public User registerUser(User user){
        try{
            return repository.save(user);
        }
        catch(Exception e){
            throw new RuntimeException("Error registering user");
        }
    }
    public User updateUser(User newUser, ObjectId userID){
        try {
            Optional<User> oldUserDB = repository.findById(userID);
            if (oldUserDB.isPresent()) {
                User oldUser = oldUserDB.get();
                oldUser.setUserName(newUser.getUserName() != null ? newUser.getUserName() : oldUser.getUserName());
                oldUser.setPassword(newUser.getPassword() != null ? newUser.getPassword() : oldUser.getPassword());
                return repository.save(oldUser);
            }
            else{
                throw new Exception("User not found");
            }
        }
        catch (Exception e){
            throw new RuntimeException("Error updating user");
        }
    }
}