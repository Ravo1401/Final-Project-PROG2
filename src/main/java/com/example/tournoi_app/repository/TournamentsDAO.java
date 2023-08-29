package com.example.tournoi_app.repository;



import com.example.tournoi_app.entity.Tournaments;

import java.sql.SQLException;
import java.util.List;

public interface TournamentsDAO {
    void insert(Tournaments user) throws SQLException;
    List<Tournaments> findAll() throws SQLException;
    List<Tournaments> findById(int id) throws SQLException;
    void deleteId(int id) throws SQLException;
    void update(int id, Tournaments user) throws SQLException;
}
