package com.scaler.advanced.code.pair.twotypes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Pair<LEFT_TYPE, RIGHT_TYPE> {

    private LEFT_TYPE left;
    private RIGHT_TYPE right;

    // static initialiser
    // Readability
//    public static Pair of(TYPE left, TYPE right) {
//        return new Pair(left, right);
//    }

    public LEFT_TYPE getLeft() {
        return left;
    }

    public RIGHT_TYPE getRight() {
        return right;
    }

}


// 1. new Pair(left, right);
// 2. Pair.of(left, right);

//
// Pair<Integer> P1 => TYPE => Integer
// Pair<String> P2 => TYPE   => String