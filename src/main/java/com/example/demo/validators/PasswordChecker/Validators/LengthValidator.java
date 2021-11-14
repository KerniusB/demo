package com.example.demo.validators.PasswordChecker.Validators;

public class LengthValidator implements PasswordValidator {

    private final Integer length;

    public LengthValidator(Integer length) {
        if(length == null || length < 0){
            throw new IllegalArgumentException("length cant be null");
        }
        this.length = length;
    }

    @Override
    public boolean isValid(String password) {
        return password.length() >= length;
    }
}
