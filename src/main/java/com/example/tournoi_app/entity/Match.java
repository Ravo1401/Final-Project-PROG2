package com.example.tournoi_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Match {
    public int id_match;
    public int user1_id;
    public int user2_id;
    public LocalDate match_date;
    public int user1_score;
    public int user2_score;
}
