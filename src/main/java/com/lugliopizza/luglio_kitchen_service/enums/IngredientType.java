package com.lugliopizza.luglio_kitchen_service.enums;

public enum IngredientType {
    MEAT("Мясо", "M"),
    SAUCE("Соус", "SA"),
    CHEESE("Сыр", "C"),
    VEGETABLE("Овощи", "V"),
    SPICE("Специи", "SP"),
    TOPPING("Топпинг", "T");

    private final String displayName;
    private final String code;

    IngredientType(String displayName, String code) {
        this.displayName = displayName;
        this.code = code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCode() {
        return code;
    }
}
