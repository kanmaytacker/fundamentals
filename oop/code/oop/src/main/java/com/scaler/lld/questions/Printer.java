package com.scaler.lld.questions;

public class Printer<T> {
    public Printer(T printingObject) {
        this.printingObject = printingObject;
    }

    private T printingObject;
    public void Print()
    {
        System.out.println(this.printingObject);
    }
}
