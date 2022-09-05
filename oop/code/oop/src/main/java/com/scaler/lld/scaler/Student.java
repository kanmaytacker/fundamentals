package com.scaler.lld.scaler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private String name;
    private String email;
    private String batchName;
    private Integer psp;
    private StudentStatus status = StudentStatus.ACTIVE; // ACTIVE, PAUSED, COMPLETED

    public void changeBatch(String batchName) {
        this.batchName = batchName;
    }

    // No constructor - hence default ctor will be used

}