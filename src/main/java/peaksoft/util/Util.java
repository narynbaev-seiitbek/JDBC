package peaksoft.util;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД


    public static EntityManagerFactory createEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("Peaksoft");
    }


    private final Connection connection;

    public Util() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
    }

    public Connection getConnection() {
        return connection;
    }
}
