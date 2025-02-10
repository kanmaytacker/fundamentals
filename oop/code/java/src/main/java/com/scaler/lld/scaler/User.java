package com.scaler.lld.scaler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String email;

    public void changeEmail(String email) {
        this.email = email;
    }

    // Method overloading
    // Method signature: 
    // 1. Method name
    // 2. # of args
    // 3. Data type of args

    public void printInfo() {
    }

    public void printInfo(String title) {
        System.out.println(" \n User: " + title + " " + this.getName());
    }
}

// Interfaces
// Class - Blueprint
// Interface - Blue print of behaviour
// Database db = new MySqlDB();
// Interfaces - define methods with an impl.
// Abstract - mixture of interface and class
// implemented methods + not-implemented
// Abstract classes - state
