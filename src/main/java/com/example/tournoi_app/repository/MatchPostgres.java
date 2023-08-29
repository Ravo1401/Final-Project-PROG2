package com.example.tournoi_app.repository;

import com.example.tournoi_app.entity.Match;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MatchPostgres implements MatchDAO{

    private Connection connection;
    public MatchPostgres(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Match match) throws SQLException{
        String sql = "INSERT INTO match(id_match, user1_id, user2_id, match_date, user1_score, user2_score) VALUES (?, ?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,match.getId_match());
            preparedStatement.setInt(2,match.getUser1_id());
            preparedStatement.setInt(3,match.getUser2_id());
            preparedStatement.setDate(4,Date.valueOf(match.getMatch_date()));
            preparedStatement.setInt(5,match.getUser1_score());
            preparedStatement.setInt(6,match.getUser2_score());


            preparedStatement.executeUpdate();

        }
    }

    @Override
    public List<Match> findAll() throws SQLException {
        List<Match> allMatch = new ArrayList<>();
        String sql = "SELECT * FROM match";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                allMatch.add(new Match(
                        resultSet.getInt("id_match"),
                        resultSet.getInt("user1_id"),
                        resultSet.getInt("user2_id"),
                        resultSet.getDate("match_date").toLocalDate(),
                        resultSet.getInt("user1_score"),
                        resultSet.getInt("user2_score")
                ));
            }
        }
        return allMatch;
    }

    @Override
    public List<Match> findById(int id) throws SQLException {
        List<Match> match = new ArrayList<>();
        String sql = "SELECT * FROM Match WHERE id_match = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                match.add(new Match(
                        resultSet.getInt("id_match"),
                        resultSet.getInt("user1_id"),
                        resultSet.getInt("user2_id"),
                        resultSet.getDate("match_date").toLocalDate(),
                        resultSet.getInt("user1_score"),
                        resultSet.getInt("user2_score")
                ));
            }
        }

        return match;
    }

    @Override
    public void deleteId(int id) throws SQLException {
        String sql = "DELETE FROM match WHERE id_match = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(int id, Match match) throws SQLException {
        String sql = "UPDATE match SET user1_id = ?, user2_id = ?, match_date = ?, user1_score = ?, user2_score = ? WHERE id_match= ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, match.getUser1_id());
            preparedStatement.setInt(2, match.getUser2_id());
            preparedStatement.setDate(3, Date.valueOf(match.getMatch_date()));
            preparedStatement.setInt(4, match.getUser1_score());
            preparedStatement.setInt(5, match.getUser2_score());
            preparedStatement.setInt(6,id);

            preparedStatement.executeUpdate();
        }
    }
}
