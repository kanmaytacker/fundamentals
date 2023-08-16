package com.scaler.advanced.code.pair.singletype;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Pair<TYPE> {

    private TYPE left;
    private TYPE right;

    public TYPE getLeft() {
        return left;
    }

    public TYPE getRight() {
        return right;
    }

}
