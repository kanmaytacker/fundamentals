package com.scaler.advanced.code.pair;

import java.util.ArrayList;
import java.util.List;

import com.scaler.advanced.code.pair.singletype.Pair;

public class BoundedPairRunner {
    public static void main(String[] args) {

        // Upper bound
        Pair<Integer> pair1 = new Pair<>(1, 300);
        System.out.println(calculateAverage(pair1));

        // Wildcard
        Pair<Integer> pair2 = new Pair<>(2, 200);
        List<Pair<Integer>> pairs = List.of(pair1, pair2);
        printList(pairs);

        // Lower bound
        List<Integer> list = new ArrayList<>();
        addToList(list, 1);

    }

    // Upper bound
    private static <T extends Number> double calculateAverage(Pair<T> pair) {
        return (pair.getLeft().doubleValue() + pair.getRight().doubleValue()) / 2;
    }

    // Wildcard
    private static void printList(List<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    // Lower bound
    private static <T> void addToList(List<? super T> list, T element) {
        list.add(element);
    }

}
