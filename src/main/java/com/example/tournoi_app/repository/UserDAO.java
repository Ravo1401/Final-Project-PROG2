package com.example.tournoi_app.repository;

import com.example.tournoi_app.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void insert(User user) throws SQLException;
    List<User> findAll() throws SQLException;
    List<User> findById(int id) throws SQLException;
    void deleteId(int id) throws SQLException;
    void update(int id, User user) throws SQLException;
}
