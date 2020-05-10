package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("{id}")
    public User getUserbyID(@PathVariable("id") long id) {
        return userService.getUser(id);
    }
    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
    @PutMapping("{id}")
    public void updateUser(@PathVariable("id") long id,@RequestBody User user) {
        userService.updateUser(id, user);
    }
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }
}
