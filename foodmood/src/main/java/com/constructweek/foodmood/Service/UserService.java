package com.constructweek.foodmood.Service;

import com.constructweek.foodmood.Dto.ResponseDto;
import com.constructweek.foodmood.Entity.User;
import com.constructweek.foodmood.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public ResponseEntity<ResponseDto> addUser(User user){
        User temp = userRepository.findByEmail(user.getEmail());
        if(temp == null){
            userRepository.save(user);
            return new ResponseEntity<>(new ResponseDto("Account created succesfully"), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(new ResponseDto("Email already exists"), HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<ResponseDto> getUser(User user){
        User temp = userRepository.findByEmail(user.getEmail());
        if(temp != null){
            if(temp.getPassword().equals(user.getPassword())){
                return new ResponseEntity<>(new ResponseDto("User Successfully logged in"), HttpStatus.FOUND);
            }
            else{
                return new ResponseEntity<>(new ResponseDto("Password or email Incorrect"), HttpStatus.NOT_ACCEPTABLE);
            }
        }
        return new ResponseEntity<>(new ResponseDto("Email doesn't exist"), HttpStatus.NOT_FOUND);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public ResponseEntity<ResponseDto> updatePassword(User user) {
        User temp = userRepository.findByEmail(user.getEmail());
        if(temp == null){
            return new ResponseEntity<>(new ResponseDto("Email doesn't exist"), HttpStatus.NOT_FOUND);
        }
        else if(temp.getPassword().equals(user.getPassword())){
            userRepository.updatePassword(user.getEmail(),user.getNewPassword());
            return new ResponseEntity<>(new ResponseDto("Password updated successfully."), HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(new ResponseDto("Password or email Incorrect"), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<ResponseDto> deleteUser(User user) {
        User temp = userRepository.findByEmail(user.getEmail());
        if(temp == null){
            return new ResponseEntity<>(new ResponseDto("Email doesn't exist"), HttpStatus.NOT_FOUND);
        }
        else if(temp.getPassword().equals(user.getPassword())){
            userRepository.deleteAccount(user.getEmail());
            return new ResponseEntity<>(new ResponseDto("Account deleted successfully."), HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(new ResponseDto("Password or email Incorrect"), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
