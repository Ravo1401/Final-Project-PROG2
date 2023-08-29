package com.example.tournoi_app.controller;


import com.example.tournoi_app.entity.User;
import com.example.tournoi_app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {
    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/user")
    public List<User> getUser() throws SQLException{
        return service.findAllUser();
    }
    @GetMapping("/user/{id}")
    public List<User> getUserById(@PathVariable int id) throws SQLException{
        return service.findUserById(id);
    }
    @PostMapping("/user")
    public void insertUser(@RequestBody User user) throws SQLException{
        service.insert(user);
    }
    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") int id)throws SQLException{
        service.deleteUserById(id);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestBody User user) throws SQLException {
        service.updateByid(id, user);
    }
}
