package com.example.demo.validators.EmailValidator;

import java.util.List;

public class EmailValidator {

    public boolean isValid(String email, List<String> forbiddenSymbols, List<String> domainAndTLD) {
        if (email == null) {
            return false;
        }
        var containsETA = checkForEta(email);
        var hasForbiddenSymbols = forbiddenSymbols(email, forbiddenSymbols);
        var correctDomainAndTLD = domainAndTLD.stream().anyMatch(tld -> email.endsWith("@" + tld));
        return containsETA && !hasForbiddenSymbols && correctDomainAndTLD;
    }

    private boolean checkForEta(String email) {
        var count = 0;
        for (char c : email.toCharArray()) {
            if (c == '@') {
                count++;
            }
        }
        return count == 1;
    }

    private boolean forbiddenSymbols(String email, List<String> forbiddenSymbols) {
        for (String symbol : forbiddenSymbols) {
            if (email.contains(symbol)) {
                return true;
            }
        }
        return false;
    }
}
