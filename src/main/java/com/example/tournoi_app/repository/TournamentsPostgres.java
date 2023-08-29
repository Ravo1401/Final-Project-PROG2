package com.example.tournoi_app.repository;

import com.example.tournoi_app.entity.Tournaments;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TournamentsPostgres implements TournamentsDAO{

    private Connection connection;
    public TournamentsPostgres(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Tournaments tournaments) throws SQLException{
        String sql = "INSERT INTO tournaments(id_tournaments, name, date, location) VALUES (?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,tournaments.getId_tournaments());
            preparedStatement.setString(2,tournaments.getName());
            preparedStatement.setDate(3, Date.valueOf(tournaments.getDate()));
            preparedStatement.setString(4,tournaments.getLocation());

            preparedStatement.executeUpdate();

        }
    }

    @Override
    public List<Tournaments> findAll() throws SQLException {
        List<Tournaments> allTournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournaments";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                allTournaments.add(new Tournaments(
                        resultSet.getInt("id_tournaments"),
                        resultSet.getString("name"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getString("location")

                ));
            }
        }
        return allTournaments;
    }

    @Override
    public List<Tournaments> findById(int id) throws SQLException {
        List<Tournaments> tournaments = new ArrayList<>();
        String sql = "SELECT * FROM tournaments WHERE id_tournaments = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                tournaments.add(new Tournaments(
                        resultSet.getInt("id_tournaments"),
                        resultSet.getString("name"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getString("location")
                ));
            }
        }

        return tournaments;
    }

    @Override
    public void deleteId(int id) throws SQLException {
        String sql = "DELETE FROM tournaments WHERE id_tournaments = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(int id, Tournaments tournaments) throws SQLException {
        String sql = "UPDATE tournaments SET name = ?, date = ?, location = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, tournaments.getName());
            preparedStatement.setDate(2, Date.valueOf(tournaments.getDate()));
            preparedStatement.setString(3, tournaments.getLocation());
            preparedStatement.setInt(4,id);

            preparedStatement.executeUpdate();
        }
    }
}
