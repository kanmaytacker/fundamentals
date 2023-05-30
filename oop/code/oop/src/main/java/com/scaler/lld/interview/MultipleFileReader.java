package com.scaler.lld.interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 6:17 - 6:25
// IST - 10:55 PM BREAK

public class MultipleFileReader {
    // Cyclomatic complexity
    public static void main(String[] args) {
        try {
            readQuestions();
            readAnswers();
        } catch (QuestionsNotFoundException | AnswersNotFoundExceptions exception) {
            exception.printStackTrace();
            // Ask the user for the correct file name
        }
    }

    private static void readQuestions() {
        try {
            String questions = readFile("src/main/resources/questions.txt");
            System.out.println(questions);
        } catch (FileNotFoundException exception) {
            throw new QuestionsNotFoundException();
        }
    }

    private static void readAnswers() {
        try {
            String answers = readFile("src/main/resources/answer.txt");
            System.out.println(answers);
        } catch (FileNotFoundException exception) {
            throw new AnswersNotFoundExceptions();
        }
    }

    private static String readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String data = "";

        while (scanner.hasNextLine()) {
            data += scanner.nextLine();
        }

        return data;
    }
}
