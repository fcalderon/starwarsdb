package com.calderonf.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Connection Helper
 * Created on 11/16/16.
 */
public class ConnectionHelper {
    private static final String DEFAULT_CONNECTION_URL = "jdbc:mysql://localhost:3306/starwarsFINAL?autoReconnect=true&useSSL=false";
    public static Connection getConnection(String username, String password) {
        return getConnection(DEFAULT_CONNECTION_URL, username, password);
    }

    /**
     * Returns the connection or null if theres a problem
     * @param url the jdbc url
     * @param username the username
     * @param password the password
     * @return
     */
    public static Connection getConnection(String url, String username, String password){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
