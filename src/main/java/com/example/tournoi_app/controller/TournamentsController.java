package com.example.tournoi_app.controller;

import com.example.tournoi_app.entity.Tournaments;
import com.example.tournoi_app.service.TournamentsService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class TournamentsController {
    private TournamentsService service;

    public TournamentsController(TournamentsService service){
        this.service = service;
    }

    @GetMapping("/tournaments")
    public List<Tournaments> getTournaments() throws SQLException {
        return service.findAllTournaments();
    }
    @GetMapping("/tournaments/{id}")
    public List<Tournaments> getTournamentsById(@PathVariable int id) throws SQLException{
        return service.findTournamentsById(id);
    }
    @PostMapping("/tournaments")
    public void insertTournaments(@RequestBody Tournaments tournaments) throws SQLException{
        service.insert(tournaments);
    }
    @DeleteMapping("/tournaments/{id_tournaments}")
    public void deleteTournamentsById(@PathVariable("id_tournaments") int id_tournaments)throws SQLException{
        service.deleteTournamentsById(id_tournaments);
    }

    @PutMapping("/tournaments/{id_tournaments}")
    public void updateTournaments(@PathVariable("id_tournaments") int id_tournaments, @RequestBody Tournaments tournaments) throws SQLException {
        service.updateByid(id_tournaments, tournaments);
    }
}
