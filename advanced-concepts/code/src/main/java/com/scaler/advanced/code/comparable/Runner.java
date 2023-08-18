package com.scaler.advanced.code.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Runner {
    
    public static void main(String[] args) {
        Pair<Integer> pair1 = new Pair<>(1, 300);
        Pair<Integer> pair2 = new Pair<>(2, 200);
        List<Pair<Integer>> pairs = Arrays.asList(pair1, pair2);

        Collections.sort(pairs);
        
        for (Pair<Integer> pair : pairs) {
            System.out.println(pair.getLeft() + " " + pair.getRight());
        }

        

    }
    
}
