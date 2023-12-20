package ru.mezenova.MySecondTestAppSpringBoot.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessages {
    EMPTY(""),
    VALIDATION("Ошибка валидации"),
    UNSUPPORTED("Произошла не предвиденная ошибка"),

    UNKNOWN("Не потдерживаемая ошибка");

    private final String description;

    ErrorMessages(String description) {
        this.description = description;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }
}
