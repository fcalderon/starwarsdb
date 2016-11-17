package com.calderonf.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created on 11/16/16.
 */
public class Character {
    private static final String COLUMN_CHARACTER_NAME = "character_name";
    private static final String COLUMN_RACE = "race";
    private static final String COLUMN_HOME_WORLD = "homeworld";
    private static final String COLUMN_AFFILIATION = "affiliation";
    private String name;
    private String homeWorld;
    private String affiliation;
    private String race;

    Character(ResultSet resultSet){
        try {
            name = resultSet.getString(COLUMN_CHARACTER_NAME);
            homeWorld = resultSet.getString(COLUMN_HOME_WORLD);
            race = resultSet.getString(COLUMN_RACE);
            affiliation = resultSet.getString(COLUMN_AFFILIATION);
        } catch (SQLException e) {
            System.out.print("Columns not found");
            e.printStackTrace();
        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public void setHomeWorld(String homeWorld) {
        this.homeWorld = homeWorld;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", homeWorld='" + homeWorld + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", race='" + race + '\'' +
                '}';
    }
}
