package com.scaler.advanced.code.comparable;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Pair<TYPE extends Comparable<TYPE>> implements Comparable<Pair<TYPE>> {

    private TYPE left;
    private TYPE right;

    public TYPE getLeft() {
        return left;
    }

    public TYPE getRight() {
        return right;
    }

    @Override
    public int compareTo(Pair<TYPE> pair) {
        return right.compareTo(pair.getRight());
        
    }

}