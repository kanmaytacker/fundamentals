package com.scaler.lld.scaler;

public class Student extends User {

    private String batchName;
    private Integer psp;
    private StudentStatus status = StudentStatus.ACTIVE;


    public Student(String name, String email, Integer age, String address, String batchName, Integer psp, StudentStatus status) {
        super(name, email, psp, batchName);
        this.batchName = batchName;
        this.psp = psp;
        this.status = status;
    }

    public String getBatchName() {
        return this.batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Integer getPsp() {
        return this.psp;
    }

    public void setPsp(Integer psp) {
        this.psp = psp;
    }

    public StudentStatus getStatus() {
        return this.status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public void changeBatch(String batchName) {
        this.batchName = batchName;
    }

    public void pauseCourse() {
        this.status = StudentStatus.PAUSED;
    }
    
}
