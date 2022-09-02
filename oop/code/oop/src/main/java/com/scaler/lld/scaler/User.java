package com.scaler.lld.scaler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private String email;
    private Integer age;
    private String address;

    public void changeEmail(String email) {
        this.email = email;
    }
}
