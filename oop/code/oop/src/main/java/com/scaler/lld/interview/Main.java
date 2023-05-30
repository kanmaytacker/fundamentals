package com.scaler.lld.interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
           String response = readFile("src/main/resources/test.txt");
           System.out.println(response.toUpperCase());

        } catch (FileNotFoundException exception) {
            System.out.println("File not found");
        } catch (RuntimeException e) {
            System.out.println("Some runtime exception happened");
            // Swallowing/Supressing the error
            // Fail fast
        }

        System.out.println("Did the code run?");
    }

    private static String readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        return null;
    }
}

// main --> readTest --> readFile
// readFile --> readTest --> main
