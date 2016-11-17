package com.calderonf;

import com.calderonf.model.Character;
import com.calderonf.model.CharactersHelper;
import com.calderonf.util.ConnectionHelper;
import com.calderonf.util.UserInputHelper;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created on 11/16/16.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        boolean exit = false;
        System.out.println("Welcome to the Starwars DB.");
        System.out.println("Enter 'exit' as input to exit the application");
        while(!exit) {
            UserInputHelper inputHelper = new UserInputHelper();
            String username = inputHelper.getStringInput("Enter username:");

            if ((username != null && username.contains("exit"))) {
                break;
            }

            String password = inputHelper.getStringInput("Enter password:");

            if ((password != null && password.contains("exit"))) {
                break;
            }

            if (username == null || username.isEmpty()) {
                System.out.println("Must provide a valid username");
                continue;
            } else if (password == null || password.isEmpty()) {
                System.out.println("Must provide a valid password");
                continue;
            }

            Connection connection = ConnectionHelper.getConnection(username, password);

            if (connection == null) {
                System.out.println("Unable to connect to the database, please enter a valid username and password");
                continue;
            }

            ArrayList<Character> characters = CharactersHelper.getAllCharacters(connection);

            while (true) {
                String characterName = inputHelper.getStringInput("Enter a character's name: ");

                if ((characterName != null && characterName.contains("exit"))) {
                    exit = true;
                    break;
                }

                if (characterName == null || characterName.isEmpty()) {
                    System.out.println("Must provide a valid character's name");
                    continue;
                }

                int characterIndex = CharactersHelper.getCharacterIndex(characterName, characters);

                if (characterIndex < 0){
                    System.out.println("No characters found with that name: " + characterName);
                    continue;
                }

                System.out.println(CharactersHelper.trackCharacter(characterName, ConnectionHelper.getConnection(username, password)));

                return;
            }
        }
    }
}

