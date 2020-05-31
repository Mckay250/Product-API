package com.decema.myCommerce.service;

import com.decema.myCommerce.model.NewUserRequest;
import com.decema.myCommerce.model.User;
import com.decema.myCommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public String addUser(User user) {
        Optional<User> existingUser = getUserByEmail(user.getEmail());
        if (existingUser.isEmpty()) {
            repository.save(user);
            return "User added Successfully";
        }
        else {
//        User newUser = new User();
//        newUser.setEmail(user.getEmail());
//        newUser.setPassword(user.getPassword());
//        newUser.setFullName(user.getFullName());
//        newUser.setRole(user.getRole());
        return "User already exist";}
    }

    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(repository.findByEmail(email).orElse(null));
    }

    public String deleteUser(Integer id) {
        repository.deleteById(id);
        return "User removed from the database";
    }
}
