package com.example.tournoi_app.service;

import com.example.tournoi_app.entity.User;
import com.example.tournoi_app.repository.UserDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    private UserDAO repository;

    public UserService(UserDAO repository){
        this.repository = repository;
    }

    public List<User> findAllUser() throws SQLException{
        return repository.findAll();
    }

    public List<User> findUserById(int id) throws SQLException{
        return repository.findById(id);
    }

    public void insert(User user) throws SQLException{
        repository.insert(user);
    }

    public void deleteUserById(int id) throws SQLException{
        repository.deleteId(id);
    }

    public void updateByid(int id, User user) throws SQLException{
        repository.update(id, user);
    }
}
