package com.scaler.advanced.code.pair.basic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Pair {

    private String left;
    private String right;

    public static Pair of(String left, String right) {
        return new Pair(left, right);
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

}
