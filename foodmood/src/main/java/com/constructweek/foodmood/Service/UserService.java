package com.constructweek.foodmood.Service;

import com.constructweek.foodmood.Entity.User;
import com.constructweek.foodmood.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(User user){
        User temp = userRepository.findByEmail(user.getEmail());
        if(temp == null){
            userRepository.save(user);
            return "Account created succesfully";
        }
        else{
            return "Email already exists";
        }
    }

    public String getUser(User user){
        User temp = userRepository.findByEmail(user.getEmail());
        if(temp != null){
            if(temp.getPassword().equals(user.getPassword())) return "User Successfully logged in";
            else return "Password or email Incorrect";
        }
        return "Email doesn't exist";
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public String updatePassword(User user) {
        User temp = userRepository.findByEmail(user.getEmail());
        if(temp == null){
            return "User doesn't exist";
        }
        else if(temp.getPassword().equals(user.getPassword())){
            userRepository.updatePassword(user.getEmail(),user.getNewPassword());
            return  "Password updated successfully.";
        }
        else{
            return "Email and Password do not match.";
        }
    }

    public String deleteUser(User user) {
        User temp = userRepository.findByEmail(user.getEmail());
        if(temp == null){
            return "User doesn't exist";
        }
        else if(temp.getPassword().equals(user.getPassword())){
            userRepository.deleteAccount(user.getEmail());
            return  "Account deleted successfully.";
        }
        else{
            return "Email and Password do not match.";
        }
    }
}
