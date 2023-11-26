package com.hahaton.backend.model.status;

public enum RequestStatus {
    COMPLETED("Выполнено"),
    IN_PROCESS("В процессе"),
    WAITING("В обработке"),
    REJECTED("Отказано");

    private final String ruName;

    RequestStatus(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
