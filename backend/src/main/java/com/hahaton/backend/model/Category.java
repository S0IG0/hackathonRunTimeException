package com.hahaton.backend.model;

public enum Category {
    WATER("Вода"), LIGHT("Свет"), GASLIGHT("Газ"), HEATING("Отопление"), STREET("Улица"), OTHER("Другое");

    private final String ruName;

    Category(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
