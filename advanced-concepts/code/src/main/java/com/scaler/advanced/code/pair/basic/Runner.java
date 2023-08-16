package com.scaler.advanced.code.pair.basic;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        // Raw type
        Pair nameToEmailMapping = Pair.of("Tantia Tope", "tantia@in");

        List<Pair> nameToEmailMappings = List.of(nameToEmailMapping);
        for (Pair idToEmailMapping : nameToEmailMappings) {
            System.out.println(idToEmailMapping.getLeft() + " " + idToEmailMapping.getRight());
        }
    }
}