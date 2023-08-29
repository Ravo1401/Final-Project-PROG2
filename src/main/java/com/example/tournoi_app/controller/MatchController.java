package com.example.tournoi_app.controller;

import com.example.tournoi_app.entity.Match;
import com.example.tournoi_app.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MatchController {
    private MatchService service;

    public MatchController(MatchService service){
        this.service = service;
    }

    @GetMapping("/match")
    public List<Match> getMatch() throws SQLException {
        return service.findAllMatch();
    }
    @GetMapping("/match/{id_match}")
    public List<Match> getMatchById(@PathVariable int id_match) throws SQLException{
        return service.findMatchById(id_match);
    }
    @PostMapping("/match")
    public void insertMatch(@RequestBody Match match) throws SQLException{
        service.insert(match);
    }
    @DeleteMapping("/match/{id_match}")
    public void deleteMatchById(@PathVariable("id_match") int id_match)throws SQLException{
        service.deleteMatchById(id_match);
    }

    @PutMapping("/match/{id_match}")
    public void updateMatch(@PathVariable("id_match") int id_match, @RequestBody Match match) throws SQLException {
        service.updateByid(id_match, match);
    }
}
