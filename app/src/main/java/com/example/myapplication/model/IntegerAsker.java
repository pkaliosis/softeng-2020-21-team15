package com.example.myapplication.model;

import java.io.InputStream;
import java.util.Scanner;

/**
 * <p>
 * This class includes mockito framework API in order to mock some specific functionalities that require an integer as a response to a specific question
 * </p>
 */
public class IntegerAsker {
    private final Scanner scanner;

    public IntegerAsker(InputStream in) {
        scanner = new Scanner(in);
    }

    public int ask(String message) {
        return scanner.nextInt();
    }
}