package com.constructweek.foodmood.Controller;

import com.constructweek.foodmood.Entity.User;
import com.constructweek.foodmood.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{

    @Autowired
    UserService userService;

    @GetMapping("/user/login/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PostMapping("/user/signup")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

}
