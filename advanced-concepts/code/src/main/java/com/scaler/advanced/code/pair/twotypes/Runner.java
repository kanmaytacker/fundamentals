package com.scaler.advanced.code.pair.twotypes;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        // Raw type
        Pair<String, String> nameToEmailMapping = new Pair<>("Tantia Tope", "tantia@in");
        Pair<Integer, String> idToEmail = new Pair<>(1, "tantia@in"); // Type safety

        List<Pair<String, String>> nameToEmailMappings = List.of(nameToEmailMapping);
        for (Pair<String, String> idToEmailMapping : nameToEmailMappings) {
            System.out.println(idToEmailMapping.getLeft() + " " + idToEmailMapping.getRight());
        }

        List<Pair<Integer, String>> idToAgeMappings = List.of(idToEmail);
        for (Pair<Integer, String> idToAgeMapping : idToAgeMappings) {
            System.out.println(idToAgeMapping.getLeft() + " " + idToAgeMapping.getRight());
        }
    }
}

// Pair of integers => left and right integer
// Pair of string => left and right string
// Pair of doubles => left and right doubles
// Parametric polymorphism

// Pair of String and Integer
// Pair of String and String
// Pair of Integer and String

