package ru.mezenova.MySecondTestAppSpringBoot.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {
    ERP("ERP"),
    CRM("CRM"),
    WMS("WMS"),
    SERVICE_ONE("Service_1");



    private final String name;

    Systems(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }


}
