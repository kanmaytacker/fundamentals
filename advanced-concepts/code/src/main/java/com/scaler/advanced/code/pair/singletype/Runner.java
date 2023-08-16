package com.scaler.advanced.code.pair.singletype;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Pair<String> nameToEmailMapping = new Pair<>("Tantia Tope", "tantia@in");
        Pair<Integer> idToAge = new Pair<>(1, 200);

        List<Pair<String>> nameToEmailMappings = List.of(nameToEmailMapping);
        for (Pair<String> idToEmailMapping : nameToEmailMappings) {
            System.out.println(idToEmailMapping.getLeft() + " " + idToEmailMapping.getRight());
        }

        List<Pair<Integer>> idToAgeMappings = List.of(idToAge);
        for (Pair<Integer> idToAgeMapping : idToAgeMappings) {
            System.out.println(idToAgeMapping.getLeft() + " " + idToAgeMapping.getRight());
        }
    }
}