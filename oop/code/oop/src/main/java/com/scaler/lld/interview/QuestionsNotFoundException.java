package com.scaler.lld.interview;

public class QuestionsNotFoundException extends RuntimeException {
    public QuestionsNotFoundException() {
        super("Question file not found");
    }
}
