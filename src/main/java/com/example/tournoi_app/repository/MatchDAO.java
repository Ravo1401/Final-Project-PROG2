package com.example.tournoi_app.repository;

import com.example.tournoi_app.entity.Match;

import java.sql.SQLException;
import java.util.List;

public interface MatchDAO {
    void insert(Match match) throws SQLException;
    List<Match> findAll() throws SQLException;
    List<Match> findById(int id) throws SQLException;
    void deleteId(int id) throws SQLException;
    void update(int id, Match match) throws SQLException;
}
