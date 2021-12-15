package com.constructweek.foodmood.Service;

import com.constructweek.foodmood.Entity.User;
import com.constructweek.foodmood.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User getUser(int userId){
        return userRepository.findById(userId).get();
    }
}
