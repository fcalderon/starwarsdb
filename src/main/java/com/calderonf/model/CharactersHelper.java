package com.calderonf.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Character helper
 * Created on 11/16/16.
 */
public class CharactersHelper {
    private final static String SELECT_CHARACTERS_STATEMENT = "SELECT * FROM characters";
    private final static String TRACK_CHARACTER_STATEMENT = "{ CALL track_character(?)}";

    /**
     * Finds all the characters in the database
     *
     * @param connection a connection
     * @return a list of characters
     * @throws SQLException if an exception is thrown
     */
    public static ArrayList<Character> getAllCharacters(Connection connection) throws SQLException {

        try {
            Statement stmt=connection.createStatement();
            ResultSet rs= stmt.executeQuery(SELECT_CHARACTERS_STATEMENT);
            ArrayList<Character> characters = new ArrayList<>();

            while(rs.next()) {
                characters.add(new Character(rs));
            }

            return characters;
        } finally {
            connection.close();
        }

    }

    /**
     * Returns the index of the character with the given name or -1 if not found
     * @param characterName the name
     * @param characters the list of characters
     * @return the index
     */
    public static int getCharacterIndex(String characterName, ArrayList<Character> characters) {
        int counter = -1;
        for (Character c : characters) {
            counter++;
            if (c.getName().equals(characterName)) {
                return counter;
            }
        }
        return -1;
    }

    /**
     * Calls the track_character procedure with the given character name and returns
     * the result set as a String
     * @param characterName the name
     * @param connection the connection
     * @return the result set as string
     */
    public static String trackCharacter(String characterName, Connection connection) {
        try (CallableStatement statement = connection.prepareCall(TRACK_CHARACTER_STATEMENT)) {
            statement.setString(1, characterName);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                return String.format(Locale.getDefault(),
                        "character_name: %s\nplanet: %s\nmovie_title: %s\nscene_length: %s\n",
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
