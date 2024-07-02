package com.scaler.lld;

import java.util.List;

import com.scaler.lld.scaler.Student;
import com.scaler.lld.scaler.User;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        User student = new Student("student", "student@scaler.in", "batch", 100);
        student.printInfo(); // inheritance
    }

    public static void resetEmail(List<User> users) {
        for (User user : users) {
            user.changeEmail("");

            if (user instanceof Student) {
                Student student = (Student) user;

                System.out.println("Name :" + student.getName() + " " + student.getPsp());

                student.setPsp(0);
                System.out.println("Name :" + student.getName() + " " + student.getPsp());

            }            

        }

    }
}

// Reusable code
// In order to reset email, I just had to call the parent's changeEmail fn
// Instead of defining a method for each class
// instanceof
// A a = (A) b;
// 6:05
// 10:35
// Three types of DP
// 1. Creational - OOP
// Factory - Simple Factory - No OOP
// 2. Structural - 
// 3. Behavioural -  

// 1. Subtyping
//  - Compile and run time

// Method overloading - Compile time
// 2. Generic Polymorphism
// 3. Adhoc polymorphism - Duck Typing

// PATCH /edit-student (JSON patchBody) 
// { field: "name", op: "set", value: "Tanmay"}