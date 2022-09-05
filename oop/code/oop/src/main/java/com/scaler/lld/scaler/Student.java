package com.scaler.lld.scaler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {

    private String name;
    private String email;
    private String batchName;
    private Integer psp;
    private StudentStatus status = StudentStatus.ACTIVE; // ACTIVE, PAUSED, COMPLETED

    // Define parametrised constructor

    public Student(String name, String email, String batchName, Integer psp) {
        this.name = name;
        this.email = email;
        this.batchName = batchName;
        this.psp = psp;
    }

    public void changeBatch(String batchName) {
        this.batchName = batchName;
    }


}