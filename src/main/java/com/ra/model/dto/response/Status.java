package com.ra.model.dto.response;

public enum Status {
    ACTIVE(true, "Active"),
    BLOCK(false, "Block");

    private final boolean value;
    private final String displayValue;

    Status(boolean value, String displayValue) {
        this.value = value;
        this.displayValue = displayValue;
    }

    public boolean getValue() {
        return value;
    }

}
