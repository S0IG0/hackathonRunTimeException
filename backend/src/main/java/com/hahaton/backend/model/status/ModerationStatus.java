package com.hahaton.backend.model.status;

public enum ModerationStatus {
    PENDING("Ожидание модерации"),
    PUBLISHED("Опубликовано"),
    REJECTED("Отказано в публикации");

    private final String ruName;

    ModerationStatus(String name) {
        this.ruName = name;
    }

    public String getRuName() {
        return ruName;
    }
}
