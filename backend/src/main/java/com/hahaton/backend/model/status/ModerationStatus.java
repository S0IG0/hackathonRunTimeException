package com.hahaton.backend.model.status;

import com.hahaton.backend.model.Category;

public enum ModerationStatus {
    PENDING("Ожидание модерации"),
    PUBLISHED("Опубликовано"),
    REJECTED("Отказано в публикации");

    private final String ruName;

    ModerationStatus(String name) {
        this.ruName = name;
    }

    public static ModerationStatus getByRuName (String name) {
        for (ModerationStatus moderationStatus : values()) {
            if (moderationStatus.getRuName().equals(name)) {
                return moderationStatus;
            }
        }
        throw new IllegalArgumentException("No such status with Russian name: " + name);

    }

    public String getRuName() {
        return ruName;
    }
}
