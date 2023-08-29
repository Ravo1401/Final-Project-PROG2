package com.example.tournoi_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Tournaments {
    public int id_tournaments;
    public String name;
    public LocalDate date;
    public String location;
}
