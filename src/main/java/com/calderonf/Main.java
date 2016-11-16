package com.calderonf;

import com.calderonf.util.ConnectionHelper;

import java.sql.*;

/**
 * Created on 11/16/16.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        connect();
    }

    private static void connect() throws SQLException {
        Connection connection = ConnectionHelper.getConnection("root", "root");
        Statement stmt=connection.createStatement();
        ResultSet rs= stmt.executeQuery("select * from emp");
        while(rs.next()) {
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

        }
        connection.close();

    }
}

