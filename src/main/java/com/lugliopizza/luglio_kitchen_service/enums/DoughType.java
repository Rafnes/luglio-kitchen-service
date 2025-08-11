package com.lugliopizza.luglio_kitchen_service.enums;

public enum DoughType {
    THIN("Толстое"),
    TRADITIONAL("Традиционное");

    private final String displayName;

    DoughType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
