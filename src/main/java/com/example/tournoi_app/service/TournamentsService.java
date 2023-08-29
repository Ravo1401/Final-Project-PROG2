package com.example.tournoi_app.service;

import com.example.tournoi_app.entity.Tournaments;
import com.example.tournoi_app.repository.TournamentsDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TournamentsService {
    private TournamentsDAO repository;

    public TournamentsService(TournamentsDAO repository){
        this.repository = repository;
    }

    public List<Tournaments> findAllTournaments() throws SQLException {
        return repository.findAll();
    }

    public List<Tournaments> findTournamentsById(int id) throws SQLException{
        return repository.findById(id);
    }

    public void insert(Tournaments tournaments) throws SQLException{
        repository.insert(tournaments);
    }

    public void deleteTournamentsById(int id) throws SQLException{
        repository.deleteId(id);
    }

    public void updateByid(int id, Tournaments tournaments) throws SQLException{
        repository.update(id, tournaments);
    }
}
