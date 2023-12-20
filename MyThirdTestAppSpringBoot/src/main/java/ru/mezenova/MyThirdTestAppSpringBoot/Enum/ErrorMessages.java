package ru.mezenova.MyThirdTestAppSpringBoot.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessages {
    EMPTY(""),
    VALIDATION("Произошла ошибка валидации"),
    UNSUPPORTED("Не предвиденная ошибка"),

    UNKNOWN("Произощла не потдерживаемая ошибка");

    private final String description;

    ErrorMessages(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
}
