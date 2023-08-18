package com.scaler.advanced.code;

import java.util.Collections;
import java.util.TreeSet;

public class TreeSetRunner {
    public static void main(String[] args) {

        TreeSet<Integer> idSet = new TreeSet<>(Collections.reverseOrder());


        idSet.add(100);
        idSet.add(100);

        idSet.add(30);
        idSet.add(30);



        for (Integer value : idSet) {
            System.out.println(value);
        }

    }
}
