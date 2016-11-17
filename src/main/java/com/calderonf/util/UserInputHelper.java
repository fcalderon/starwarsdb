package com.calderonf.util;

import java.util.Scanner;

/**
 * Helper for getting user input
 * Created on 11/16/16.
 */
public class UserInputHelper {
    private Scanner scanner;

    /**
     * Constructs this helper with a new instance of the scanner
     */
    public UserInputHelper() {
        this(new Scanner(System.in));
    }

    /**
     * Constructs the UserInputHelper
     * @param scanner the scanner to use (should be initialized with {@link System#in}
     */
    public UserInputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getStringInput(String message){
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        System.out.println(message);
        return scanner.nextLine();
    }
}
