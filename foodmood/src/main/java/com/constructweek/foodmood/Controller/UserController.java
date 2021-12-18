package com.constructweek.foodmood.Controller;

import com.constructweek.foodmood.Entity.User;
import com.constructweek.foodmood.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{

    @Autowired
    UserService userService;

    @GetMapping("/user/login")
    public String getUser(@RequestBody User user){
        return userService.getUser(user);
    }

    @PostMapping("/user/signup")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PutMapping("/user/update")
    public String updatePassword(@RequestBody User user){
        return userService.updatePassword(user);
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

}
