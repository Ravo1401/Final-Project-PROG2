package com.example.tournoi_app.repository;


import com.example.tournoi_app.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserPostgres implements UserDAO{

    private Connection connection;
    public UserPostgres(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insert(User user) throws SQLException{

        String sql = "INSERT INTO \"user\"(id, name, pseudo) VALUES (?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getPseudo());

            preparedStatement.executeUpdate();

        }
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> allUser = new ArrayList<>();
        String sql = "SELECT * FROM \"user\"";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                allUser.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("pseudo")
                ));
            }
        }
        return allUser;
    }

    @Override
    public List<User> findById(int id) throws SQLException {
        List<User> user = new ArrayList<>();
        String sql = "SELECT * FROM \"user\" WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
          preparedStatement.setInt(1, id);
          ResultSet resultSet = preparedStatement.executeQuery();

          while (resultSet.next()){
              user.add(new User(
                      resultSet.getInt("id"),
                      resultSet.getString("name"),
                      resultSet.getString("pseudo")
              ));
          }
        }

        return user;
    }

    @Override
    public void deleteId(int id) throws SQLException {
        String sql = "DELETE FROM \"user\" WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void update(int id, User user) throws SQLException {
        String sql = "UPDATE \"user\" SET name = ?, pseudo = ? WHERE id= ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPseudo());
            preparedStatement.setInt(3,id);

            preparedStatement.executeUpdate();
        }
    }
}
