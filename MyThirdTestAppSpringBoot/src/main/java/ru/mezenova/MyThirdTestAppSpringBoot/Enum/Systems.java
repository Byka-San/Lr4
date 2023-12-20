package ru.mezenova.MyThirdTestAppSpringBoot.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {
    ERP("ERP"),
    CRM("CRM"),
    WMS("WMS");



    private final String name;

    Systems(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }


}
