package com.constructweek.foodmood.Controller;

import com.constructweek.foodmood.Dto.ResponseDto;
import com.constructweek.foodmood.Entity.User;
import com.constructweek.foodmood.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController{

    @Autowired
    UserService userService;


    @GetMapping("/user/login")
    public ResponseEntity<ResponseDto> getUser(@RequestBody User user){
        return userService.getUser(user);
    }

    @PostMapping("/user/signup")
    public ResponseEntity<ResponseDto> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PutMapping("/user/update")
    public ResponseEntity<ResponseDto> updatePassword(@RequestBody User user){
        return userService.updatePassword(user);
    }

    @GetMapping("/user/delete")
    public ResponseEntity<ResponseDto> deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

}
