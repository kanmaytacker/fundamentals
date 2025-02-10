package com.scaler.lld.questions;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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

    public void printInvoice()
    {
        Printer<List<String>> invoicePrinter = new Printer<>(getInvoiceDetails());
        invoicePrinter.Print();
    }

    public List<String> getInvoiceDetails()
    {
        List<String> invoiceDetails = new ArrayList<>();
        invoiceDetails.add(quantity + "x " + book.getName() + " " + book.getPrice() + "$");
        invoiceDetails.add("Discount Rate: " + discountRate);
        invoiceDetails.add("Tax Rate: " + taxRate);
        invoiceDetails.add("Total: " + total);

        return invoiceDetails;
    }

    public void saveToFile()
    {
        FileHandler handler = new FileHandler();
        handler.CreateFile(getInvoiceDetails());
    }

}
