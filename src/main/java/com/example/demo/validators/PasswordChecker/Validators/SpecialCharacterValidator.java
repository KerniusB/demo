package com.example.demo.validators.PasswordChecker.Validators;

public class SpecialCharacterValidator implements PasswordValidator {

    private final String specialCharacter;

    public SpecialCharacterValidator(String specialCharacter) {
        if(specialCharacter == null || specialCharacter.isEmpty()){
            throw new IllegalArgumentException("special character cant be empty or null");
        }
        this.specialCharacter = specialCharacter;
    }

    @Override
    public boolean isValid(String password) {
        for (char c : specialCharacter.toCharArray()) {
            if(password.contains(String.valueOf(c))){
                return true;
            }
        }
        return false;
    }
}
