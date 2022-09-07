package com.scaler.lld.questions;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Invoice {
    private Book book;
    private Integer quantity;
    private Double discountRate;
    private Double taxRate;

    @Getter(AccessLevel.NONE)
    private double total; // Will not generate a getter

    public Double getTotal() {
        double price = ((book.getPrice() - book.getPrice() * discountRate) * this.quantity);
        return price * (1 + taxRate);
    }

    public void printInvoice() {
        System.out.println(quantity + "x " + book.getName() + " " + book.getPrice() + "$");
        System.out.println("Discount Rate: " + discountRate);
        System.out.println("Tax Rate: " + taxRate);
        System.out.println("Total: " + total);
    }

    public void saveToFile(String filename) {
        // Creates a file with given name and writes the invoice
    }

}
