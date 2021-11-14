package com.example.demo.validators.PasswordChecker.Validators;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class PasswordChecker {

    private final List<PasswordValidator> validators = new ArrayList<>();

    public boolean isValid(String password) {
        if (password == null){
            throw new IllegalArgumentException("password cant be null");
        }
        for (PasswordValidator validator : validators) {
            if (!validator.isValid(password)) {
                return false;
            }
        }
        return true;
    }



    public void addValidator(PasswordValidator validator){
        if(validator == null){
            throw new IllegalArgumentException("validator cant be null");
        }
        validators.add(validator);
    }
}
