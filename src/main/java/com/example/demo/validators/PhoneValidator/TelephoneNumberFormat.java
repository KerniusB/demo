package com.example.demo.validators.PhoneValidator;

import lombok.Getter;

@Getter
public class TelephoneNumberFormat {
    private final int length;
    private final String prefix;
    private final String trunkPrefix;

    public TelephoneNumberFormat(int length, String prefix, String trunkPrefix) {
        if (prefix == null || prefix.isEmpty() || !prefix.startsWith("+") || trunkPrefix == null || trunkPrefix.isEmpty() || length <= 0) {
            throw new IllegalArgumentException("constructor doesnt allow null or empty values");
        }
        this.length = length;
        this.prefix = prefix;
        this.trunkPrefix = trunkPrefix;
    }
}
