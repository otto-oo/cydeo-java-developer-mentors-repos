package com.cydeo.enums;

public enum QuantityType {
    OUNCE("Ounce"), LB("LB"), TBSP("Tbsp");

    private String value;

    QuantityType(String value) {
        this.value = value;
    }
}
