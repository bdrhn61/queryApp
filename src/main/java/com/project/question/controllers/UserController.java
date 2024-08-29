package com.project.question.controllers;

import com.project.question.entities.User;
import com.project.question.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

   public UserController(UserService userService){
    this.userService=userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
       return userService.saveOneUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
       return userService.getOneUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser (@PathVariable Long userId,@RequestBody User newUser) {

       return userService.updateOneUser(userId,newUser);

    }

    @DeleteMapping("/{userId}")
    public void deleteOneUSer (@PathVariable Long userId){
        userService.deleteById(userId);
    }
}
