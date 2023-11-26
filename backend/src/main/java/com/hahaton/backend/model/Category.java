package com.hahaton.backend.model;

public enum Category {
    All("Все"), WATER("Вода"), LIGHT("Свет"), GASLIGHT("Газ"), HEATING("Отопление"), STREET("Улица"), OTHER("Другое");

    private final String ruName;

    Category(String ruName) {
        this.ruName = ruName;
    }

    public static Category getByRuName(String name) {
        for (Category category : values()) {
            if (category.getRuName().equals(name)) {
                return category;
            }
        }
        throw new IllegalArgumentException("No such category with Russian name: " + name);
    }

    public String getRuName() {
        return ruName;
    }

}
