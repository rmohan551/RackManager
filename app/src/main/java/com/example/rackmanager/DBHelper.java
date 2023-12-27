/*
package com.example.rackmanager;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class DBHelper {
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/rack manager";
    private static final String USER = "postgres";
    private static final String PASSWORD = "test";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public boolean testConnection() {
        try (Connection connection = getConnection()) {
            // To establish connection
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    @NotNull
    public Object getRackDao() {
        return null;
    }

    public void runInTransaction(@NotNull Function0<Unit> function) {

    }
}*/
