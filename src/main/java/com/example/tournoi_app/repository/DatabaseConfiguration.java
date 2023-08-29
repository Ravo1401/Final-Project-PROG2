package com.example.tournoi_app.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConfiguration {
    @Bean
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost/tournoi_app",
                "postgres",
                "ravo1401"
        );
    }
}
