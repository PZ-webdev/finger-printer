package com.pzwebdev.helper;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class ConsoleInputReader {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt + ": ");

        return scanner.nextLine();
    }

    public static int readInt(String prompt) {
        System.out.print(prompt + ": ");

        while (!scanner.hasNextInt()) {
            System.out.println("Wprowadź poprawną liczbę!");
            System.out.print(prompt + ": ");
            scanner.next();
        }

        return scanner.nextInt();
    }

    public static double readDouble(String prompt) {
        System.out.print(prompt + ": ");

        while (!scanner.hasNextDouble()) {
            System.out.println("Wprowadź poprawną liczbę!");
            System.out.print(prompt + ": ");
            scanner.next();
        }

        return scanner.nextDouble();
    }

    public void close() {
        scanner.close();
    }
}
