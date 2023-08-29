package com.example.tournoi_app.service;

import com.example.tournoi_app.entity.Match;
import com.example.tournoi_app.repository.MatchDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MatchService {
    private MatchDAO repository;

    public MatchService(MatchDAO repository){
        this.repository = repository;
    }

    public List<Match> findAllMatch() throws SQLException {
        return repository.findAll();
    }

    public List<Match> findMatchById(int id) throws SQLException{
        return repository.findById(id);
    }

    public void insert(Match match) throws SQLException{
        repository.insert(match);
    }

    public void deleteMatchById(int id) throws SQLException{
        repository.deleteId(id);
    }

    public void updateByid(int id, Match match) throws SQLException{
        repository.update(id, match);
    }
}
