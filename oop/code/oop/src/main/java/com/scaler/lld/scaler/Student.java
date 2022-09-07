package com.scaler.lld.scaler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends User {

    private String batchName;
    private Integer psp;
    private StudentStatus status = StudentStatus.ACTIVE; // ACTIVE, PAUSED, COMPLETED

    // Define parametrised constructor

    public Student(String name, String email, String batchName, Integer psp) {
        super(name, email);
        this.batchName = batchName;

        if (psp < 0 || psp > 100) {
            throw new IllegalArgumentException("PSP should be between 0 and 100");
        }
        this.psp = psp;
    }

    public Student() {
    }

    void changeBatch(String batchName) {
        this.batchName = batchName;
    }

    @Override
    public void printInfo() {
        System.out.println("\nStudent: " + getName() + " " + getBatchName());
    }

}