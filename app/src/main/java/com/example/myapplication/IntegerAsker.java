package com.example.myapplication;

import java.io.InputStream;
import java.util.Scanner;

public class IntegerAsker {
    private final Scanner scanner;

    public IntegerAsker(InputStream in) {
        scanner = new Scanner(in);
    }

    public int ask(String message) {
        return scanner.nextInt();
    }
}